package com.tiki.tikiFlash.features.video.queries.handlers;

import an.awesome.pipelinr.Command;
import com.tiki.tikiFlash.features.video.queries.ListAllVideo;
import com.tiki.tikiFlash.infrastructures.entities.VideoEntity;
import com.tiki.tikiFlash.infrastructures.repositories.VideoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component("ListAllVideoHandler")
@AllArgsConstructor
public class ListAllVideoHandler implements Command.Handler<ListAllVideo, ResponseEntity<Collection<VideoEntity>>> {

    private final VideoRepository videoRepository;

    @Override
    public ResponseEntity<Collection<VideoEntity>> handle(ListAllVideo query) {
        var allVideos = videoRepository.findAllByUserId(query.getUserId());

        return ResponseEntity.ok(allVideos);
    }
}
