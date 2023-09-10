package com.example.restcontrollerdemo.models.error;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SuccessResponse<T> {
    HttpStatus status;
    String message;
    T data;

    public static <T> SuccessResponse success(T data) {
        return SuccessResponse.builder().status(HttpStatus.OK).message("Successfully").data(data).build();
    }
}
