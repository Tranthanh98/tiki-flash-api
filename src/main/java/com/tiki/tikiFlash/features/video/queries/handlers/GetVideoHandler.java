package com.tiki.tikiFlash.features.video.queries.handlers;

import an.awesome.pipelinr.Command;
import com.tiki.tikiFlash.features.video.queries.GetVideo;
import com.tiki.tikiFlash.infrastructures.entities.VideoEntity;
import com.tiki.tikiFlash.infrastructures.repositories.VideoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component("GetVideoHandler")
@AllArgsConstructor
public class GetVideoHandler implements Command.Handler<GetVideo, ResponseEntity<VideoEntity>> {

    private final VideoRepository videoRepository;

    @Override
    public ResponseEntity<VideoEntity> handle(GetVideo getVideo) {
        var videoOption = videoRepository.findById(getVideo.getId());

        if(!videoOption.isPresent()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(videoOption.get());
    }
}
