package com.tiki.tikiFlash.features.video;

import an.awesome.pipelinr.Pipeline;
import com.tiki.tikiFlash.features.video.commands.ChangeVideoStatus;
import com.tiki.tikiFlash.features.video.commands.IncreaseView;
import com.tiki.tikiFlash.features.video.commands.UploadVideo;
import com.tiki.tikiFlash.features.video.queries.GetVideo;
import com.tiki.tikiFlash.features.video.queries.ListAllVideo;
import com.tiki.tikiFlash.infrastructures.controllers.BaseController;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("video")
public class VideoController extends BaseController {
    public VideoController(Pipeline pipeline) {
        super(pipeline);
    }

    @PostMapping(consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<?> uploadVideo(@Valid @ModelAttribute UploadVideo command, BindingResult bindingResult){
        return handleWithResponse(command, bindingResult);
    }

    @GetMapping
    public ResponseEntity<?> listAllVideo(){
        var query = new ListAllVideo();

        return handleWithResponse(query);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getVideo(@PathVariable Long id){
        var query = GetVideo.of(id);

        return handleWithResponse(query);
    }

    @PutMapping("/{id}/increase-view")
    public ResponseEntity<?> increaseView(@PathVariable Long id){
        var command = IncreaseView.of(id);

        return handle(command);
    }

    @PutMapping("/{id}/change-status")
    public ResponseEntity<?> changeStatus(@PathVariable Long id, @RequestBody ChangeVideoStatus command){
        command.setVideoId(id);

        return handleWithResponse(command);
    }
}
