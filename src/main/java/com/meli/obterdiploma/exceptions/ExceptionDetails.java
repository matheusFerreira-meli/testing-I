package com.meli.obterdiploma.exceptions;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class ExceptionDetails {
    private String title, message, fields, fieldsMessage;
    private LocalDateTime timestamps;
}
