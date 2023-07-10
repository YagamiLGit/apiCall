package com.tausifahmed.APICall.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PanDetails {
    private String aadhaar_seeding_status;
    private String category;
    private String full_name;
}
