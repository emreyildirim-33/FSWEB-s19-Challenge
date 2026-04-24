package com.example.fswebs19challenge.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TwitterErrorResponse {
    private int status;
    private String message;
    private  long timestamp;
}
