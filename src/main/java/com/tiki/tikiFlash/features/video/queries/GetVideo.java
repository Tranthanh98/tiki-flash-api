package com.tiki.tikiFlash.features.video.queries;

import com.tiki.tikiFlash.infrastructures.commands.BaseIdentityCommand;
import com.tiki.tikiFlash.infrastructures.entities.VideoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class GetVideo extends BaseIdentityCommand<ResponseEntity<VideoEntity>> {
    private Long id;
}
