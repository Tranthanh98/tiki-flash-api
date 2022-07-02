package com.tiki.tikiFlash.features.sampleapi.queries;

import an.awesome.pipelinr.Command;
import com.tiki.tikiFlash.infrastructures.entities.TestTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

@Data
@NoArgsConstructor
public class ListAll implements Command<ResponseEntity<Collection<TestTable>>> {
}
