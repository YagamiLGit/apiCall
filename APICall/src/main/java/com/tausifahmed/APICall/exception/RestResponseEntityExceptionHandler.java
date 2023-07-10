package com.tausifahmed.APICall.exception;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tausifahmed.APICall.model.CustomErrorResponse;
import com.tausifahmed.APICall.model.PanValidationExceptionResponse;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<PanValidationExceptionResponse> handlePanValidationException(CustomException exception) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        CustomErrorResponse customErrorResponse = objectMapper.readValue(exception.getMessage(), CustomErrorResponse.class);
        return new ResponseEntity<>(customErrorResponse.getError(), HttpStatusCode.valueOf(exception.getStatus()));
    }

}
