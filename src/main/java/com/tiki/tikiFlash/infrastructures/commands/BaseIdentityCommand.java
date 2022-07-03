package com.tiki.tikiFlash.infrastructures.commands;

import an.awesome.pipelinr.Command;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class BaseIdentityCommand<T> implements Command<T> {
    @Getter
    @Setter
    private String userId;
}
