package com.tausifahmed.APICall.controller;

import com.tausifahmed.APICall.model.PanValidationRequest;
import com.tausifahmed.APICall.model.PanValidationResponse;
import com.tausifahmed.APICall.service.PanValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/pan")
@RequiredArgsConstructor
public class PanValidationController {

    private final PanValidationService service;

    @GetMapping("/verify")
    public ResponseEntity<PanValidationResponse> panVerify(@RequestBody PanValidationRequest request) {
        PanValidationResponse response = service.panVerify(request);
        System.out.println("Response : " + response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
