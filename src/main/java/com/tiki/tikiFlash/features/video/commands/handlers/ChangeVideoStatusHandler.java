package com.tiki.tikiFlash.features.video.commands.handlers;

import an.awesome.pipelinr.Command;
import com.tiki.tikiFlash.features.video.commands.ChangeVideoStatus;
import com.tiki.tikiFlash.infrastructures.repositories.VideoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component("ChangeVideoStatusHandler")
@AllArgsConstructor
public class ChangeVideoStatusHandler implements Command.Handler<ChangeVideoStatus, ResponseEntity<Long>> {

    private final VideoRepository videoRepository;

    @Override
    public ResponseEntity<Long> handle(ChangeVideoStatus command) {
        var videoOption = videoRepository.findById(command.getVideoId());

        if(!videoOption.isPresent()){
            return ResponseEntity.notFound().build();
        }

        var video = videoOption.get();

        video.setIsActive(command.getStatus());

        videoRepository.saveAndFlush(video);

        return ResponseEntity.accepted().build();
    }
}
