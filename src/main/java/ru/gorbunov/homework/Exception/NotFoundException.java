package ru.gorbunov.homework.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
    private int code;
    public NotFoundException (int code, String msg) {
        super(msg);
        this.code = code;
    }

}
