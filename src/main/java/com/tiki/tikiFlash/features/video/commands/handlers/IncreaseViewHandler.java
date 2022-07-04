package com.tiki.tikiFlash.features.video.commands.handlers;

import an.awesome.pipelinr.Command;
import com.tiki.tikiFlash.features.video.commands.IncreaseView;
import com.tiki.tikiFlash.infrastructures.repositories.VideoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component("IncreaseViewHandler")
@AllArgsConstructor
public class IncreaseViewHandler implements Command.Handler<IncreaseView, ResponseEntity> {

    private final VideoRepository videoRepository;

    @Override
    public ResponseEntity handle(IncreaseView command) {
        var videoOption = videoRepository.findById(command.getVideoId());

        if(!videoOption.isPresent()){
            return ResponseEntity.notFound().build();
        }

        var video = videoOption.get();

        video.setTotalView(video.getTotalView() + 1);

        videoRepository.saveAndFlush(video);

        return ResponseEntity.accepted().build();
    }
}
