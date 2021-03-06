package com.tiki.tikiFlash.infrastructures.controllers;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Pipeline;
import com.tiki.tikiFlash.infrastructures.commands.BaseIdentityCommand;
import com.tiki.tikiFlash.infrastructures.responses.ResponseMessage;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@AllArgsConstructor
public class BaseController {
    private final Pipeline pipeline;

    protected <T> ResponseEntity<?> handle(Command<T> command, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return handleBadRequest(bindingResult);
        }

        if(command instanceof BaseIdentityCommand<?>){
            ((BaseIdentityCommand<ResponseEntity<T>>) command).setUserId("system-admin");
        }

        return handle(command);

    }

    protected <T> ResponseEntity<T> handle(Command<T> command) {

        if(command instanceof BaseIdentityCommand<?>){
            ((BaseIdentityCommand<ResponseEntity<T>>) command).setUserId("system-admin");
        }

        var result = command.execute(pipeline);

        return ResponseEntity.ok(result);
    }

    protected <T> ResponseEntity<?> handleWithResponse(Command<ResponseEntity<T>> command) {

        return handle(command);

    }

    protected <T> ResponseEntity<?> handleWithResponse(Command<ResponseEntity<T>> command,
                                                       BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return handleBadRequest(bindingResult);
        }

        return handle(command);

    }

    private ResponseEntity<?> handleBadRequest(BindingResult bindingResult){
        var errors = bindingResult.getFieldErrors();

        var errorRequests = new HashMap<String, String>();

        errors.forEach(i -> {
            errorRequests.put(i.getField(), i.getDefaultMessage());
        });

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ResponseMessage("invalid data" , errorRequests));
    }
}
