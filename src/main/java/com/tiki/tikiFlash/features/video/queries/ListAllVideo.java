package com.tiki.tikiFlash.features.video.queries;

import com.tiki.tikiFlash.infrastructures.commands.BaseIdentityCommand;
import com.tiki.tikiFlash.infrastructures.entities.VideoEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

@Data
@NoArgsConstructor
public class ListAllVideo extends BaseIdentityCommand<ResponseEntity<Collection<VideoEntity>>> {
}
