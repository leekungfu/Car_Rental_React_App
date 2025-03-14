package com.vn.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseMessage {
    private Boolean isSuccess;
    private String message;
}
