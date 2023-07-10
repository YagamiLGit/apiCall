package com.tausifahmed.APICall.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tausifahmed.APICall.exception.CustomException;
import com.tausifahmed.APICall.model.CustomErrorResponse;
import com.tausifahmed.APICall.model.PanValidationRequest;
import com.tausifahmed.APICall.model.PanValidationResponse;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import org.springframework.http.HttpHeaders;
import reactor.core.publisher.Mono;

@Service
public class PanValidationService {

    public PanValidationResponse panVerify(PanValidationRequest request) {
        String uri = "https://dg-sandbox.setu.co/api/verify/pan";
        WebClient webClient = WebClient.create();

        HttpHeaders headers = new HttpHeaders();
        headers.set("x-client-id", "a85913df-8721-44ff-98f2-91fc632ed556");
        headers.set("x-client-secret", "f8188e49-9cb6-44db-bf72-2796161c7710");

        return webClient.method(HttpMethod.POST)
                .uri(uri)
                .headers(httpHeaders -> httpHeaders.addAll(headers))
                .body(BodyInserters.fromValue(request))
                .exchangeToMono(this::handleResponse)
                .block();

    }

    private Mono<PanValidationResponse> handleResponse(ClientResponse response) {
        if (response.statusCode().is2xxSuccessful()) {
            return response.bodyToMono(PanValidationResponse.class);
        } else {
            return response.bodyToMono(String.class)
                    .flatMap(errorResponseBody -> {
                        // Handle the error response (e.g., 400)
                        return Mono.error(new CustomException(errorResponseBody, response.statusCode().value()));
                    });
        }
    }



}
