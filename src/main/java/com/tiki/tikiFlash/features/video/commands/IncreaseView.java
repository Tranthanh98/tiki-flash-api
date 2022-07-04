package com.tiki.tikiFlash.features.video.commands;

import an.awesome.pipelinr.Command;
import com.tiki.tikiFlash.infrastructures.commands.BaseIdentityCommand;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;

@Data
@AllArgsConstructor(staticName = "of")
public class IncreaseView implements Command<ResponseEntity> {
    private Long videoId;
}
