package com.tausifahmed.APICall.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PanValidationExceptionResponse {
    private String code;
    private String detail;
    private String traceId;
}
