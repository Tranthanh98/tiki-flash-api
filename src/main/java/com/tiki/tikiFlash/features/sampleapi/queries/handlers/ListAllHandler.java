package com.tiki.tikiFlash.features.sampleapi.queries.handlers;

import an.awesome.pipelinr.Command;
import com.tiki.tikiFlash.features.sampleapi.queries.ListAll;
import com.tiki.tikiFlash.infrastructures.entities.TestTable;
import com.tiki.tikiFlash.infrastructures.repositories.TestTableRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component("ListAllHandler")
@AllArgsConstructor
public class ListAllHandler implements Command.Handler<ListAll, ResponseEntity<Collection<TestTable>>> {

    private final TestTableRepository testTableRepository;

    @Override
    public ResponseEntity<Collection<TestTable>> handle(ListAll query) {

        var allData= testTableRepository.findAll();

        return ResponseEntity.ok(allData);
    }
}
