package com.thoughtworks.capability.gtb.restfulapidesign.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Error {
    private String message;
}