package dev.vilas.productservice.dtos;

import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
public class ExceptionDto {
    private HttpStatus errorCode;
    private String message;

    public ExceptionDto(HttpStatus status, String message) {
        this.errorCode = status;
        this.message = message;
    }
}
