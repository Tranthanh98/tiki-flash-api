package com.tiki.tikiFlash.features.video.commands.handlers;

import an.awesome.pipelinr.Command;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.tiki.tikiFlash.features.video.commands.UploadVideo;
import com.tiki.tikiFlash.infrastructures.entities.VideoEntity;
import com.tiki.tikiFlash.infrastructures.repositories.VideoRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.time.Instant;

@Component("UploadVideoHandler")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UploadVideoHandler implements Command.Handler<UploadVideo, ResponseEntity<String>> {

    private final AmazonS3 amazonS3;

    private final VideoRepository videoRepository;

    @Value("${cloud.aws.s3.bucket-name}")
    private String bucketName;

    @Value("${cloud.aws.s3-public-link}")
    private String s3PublicDomain;

    private static final Logger logger = LoggerFactory.getLogger(UploadVideoHandler.class);


    @Override
    public ResponseEntity<String> handle(UploadVideo command) {
        var videoEntity = new VideoEntity();

        videoEntity.setName(command.getFileName());
        videoEntity.setSize(command.getMultipartFile().getSize());
        videoEntity.setExtension(command.getMultipartFile().getContentType());
        videoEntity.setUserId("system-admin");

        try {
            var inputStream = new ByteArrayInputStream(command.getMultipartFile().getBytes());

            var s3Key = uploadToS3(command.getMultipartFile().getOriginalFilename(), inputStream);

            var publicLinkVideo = s3PublicDomain + s3Key;

            videoEntity.setS3Key(publicLinkVideo);

            videoRepository.saveAndFlush(videoEntity);

            return ResponseEntity.ok(publicLinkVideo);

        } catch (IOException e) {
            logger.error(e.getMessage());

            return ResponseEntity.internalServerError().build();
        }
    }

    private String uploadToS3(String fileName, InputStream inputStream) {
        var bucketKey = Timestamp.from(Instant.now()).toInstant() + "-"+ fileName;

        var metaData = new ObjectMetadata();
        metaData.setContentType("application/octet-stream");

        var putObjectRequest = new PutObjectRequest(bucketName, bucketKey, inputStream, metaData);
        amazonS3.putObject(putObjectRequest);

        return bucketKey;

    }
}
