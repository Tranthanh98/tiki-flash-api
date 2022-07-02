package com.tiki.tikiFlash.features.sampleapi.commands.handlers;

import an.awesome.pipelinr.Command;
import com.tiki.tikiFlash.features.sampleapi.commands.Create;
import com.tiki.tikiFlash.infrastructures.entities.TestTable;
import com.tiki.tikiFlash.infrastructures.repositories.TestTableRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component("CreateHandler")
@AllArgsConstructor
public class CreateHandler implements Command.Handler<Create, ResponseEntity<Long>> {

    private final TestTableRepository testTableRepository;

    @Override
    public ResponseEntity<Long> handle(Create command) {
        var testTable = new TestTable();

        testTable.setName(command.getName());

        testTableRepository.save(testTable);

        return ResponseEntity.ok(testTable.getId());
    }
}
