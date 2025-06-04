package com.example.backendtest._core.error;
import com.example.backendtest._core.error.ex.ExceptionApi400;
import com.example.backendtest._core.error.ex.ExceptionApi401;
import com.example.backendtest._core.error.ex.ExceptionApi403;
import com.example.backendtest._core.error.ex.ExceptionApi404;
import com.example.backendtest._core.util.Resp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ExceptionApi400.class)
    public ResponseEntity<?> exApi400(ExceptionApi400 e) {
        log.warn(e.getMessage());
        return Resp.fail(HttpStatus.BAD_REQUEST, e.getMessage());
    }

    @ExceptionHandler(ExceptionApi401.class)
    public ResponseEntity<?> exApi401(ExceptionApi401 e) {
        log.warn(e.getMessage());
        return Resp.fail(HttpStatus.UNAUTHORIZED, e.getMessage());
    }

    @ExceptionHandler(ExceptionApi403.class)
    public ResponseEntity<?> exApi403(ExceptionApi403 e) {
        log.warn(e.getMessage());
        return Resp.fail(HttpStatus.FORBIDDEN, e.getMessage());
    }

    @ExceptionHandler(ExceptionApi404.class)
    public ResponseEntity<?> exApi404(ExceptionApi404 e) {
        log.warn(e.getMessage());
        return Resp.fail(HttpStatus.NOT_FOUND, e.getMessage());
    }
}
