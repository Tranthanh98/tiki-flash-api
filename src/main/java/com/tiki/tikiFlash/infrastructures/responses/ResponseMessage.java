package com.tiki.tikiFlash.infrastructures.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor

public class ResponseMessage {
    @Getter
    @Setter
    private String message;

    @Getter
    @Setter
    private Map<String, String> fieldErrors;
}
