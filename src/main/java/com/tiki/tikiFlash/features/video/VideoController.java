package com.tiki.tikiFlash.features.video;

import an.awesome.pipelinr.Pipeline;
import com.tiki.tikiFlash.features.video.commands.UploadVideo;
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
}