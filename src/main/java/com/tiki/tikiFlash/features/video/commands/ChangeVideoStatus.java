package com.tiki.tikiFlash.features.video.commands;

import com.tiki.tikiFlash.infrastructures.commands.BaseIdentityCommand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangeVideoStatus extends BaseIdentityCommand<ResponseEntity<Long>> {
    private Long videoId;

    private Boolean status = false;
}
