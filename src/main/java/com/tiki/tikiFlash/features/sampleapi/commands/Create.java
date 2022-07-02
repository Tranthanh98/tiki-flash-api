package com.tiki.tikiFlash.features.sampleapi.commands;

import an.awesome.pipelinr.Command;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class Create implements Command<ResponseEntity<Long>> {

    @NotNull
    @Size(min=3, max=200,message = "Length must be greater than 3 and less than 200")
    private String name;
}
