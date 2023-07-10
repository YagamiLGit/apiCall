package com.tausifahmed.APICall.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PanValidationRequest {
    private String pan;
    private String consent;
    private String reason;
}
