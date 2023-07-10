package com.tausifahmed.APICall.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PanValidationResponse {
    private PanDetails data;
    private String message;
    private String verification;
    private String traceId;
}
