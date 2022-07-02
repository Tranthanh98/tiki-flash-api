package com.tiki.tikiFlash.features.sampleapi;

import an.awesome.pipelinr.Pipeline;
import com.tiki.tikiFlash.features.sampleapi.commands.Create;
import com.tiki.tikiFlash.features.sampleapi.queries.ListAll;
import com.tiki.tikiFlash.infrastructures.controllers.BaseController;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("sample")
public class SampleController extends BaseController {

    public SampleController(Pipeline pipeline) {
        super(pipeline);
    }

    @PostMapping
    public ResponseEntity<?> createTestTable(@Valid @RequestBody Create command,
                                             BindingResult bindingResult){
        return handle(command, bindingResult);
    }

    @GetMapping
    public ResponseEntity<?> listAll(){
        var query = new ListAll();
        return handle(query);
    }
}
