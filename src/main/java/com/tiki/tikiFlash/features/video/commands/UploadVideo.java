package com.tiki.tikiFlash.features.video.commands;

import an.awesome.pipelinr.Command;
import com.tiki.tikiFlash.infrastructures.commands.BaseIdentityCommand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UploadVideo extends BaseIdentityCommand<ResponseEntity<String>> {
    @NotNull(message = "file is mandatory")
    private MultipartFile multipartFile;

    private String fileName;
}
