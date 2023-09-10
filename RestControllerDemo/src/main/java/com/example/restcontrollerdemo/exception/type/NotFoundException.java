package com.example.restcontrollerdemo.exception.type;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class NotFoundException {
    HttpStatus status;
    String message;

    public static NotFoundException of() {
        return NotFoundException.builder().message("Bele bir data tapilmadi").status(HttpStatus.NOT_FOUND).build();
    }

    @Override
    public String toString() {
        return "NotFoundException{" +
                "status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}
