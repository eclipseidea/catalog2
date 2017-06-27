package zab.romik.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import zab.romik.exceptions.RestResourceNotFoundException;
import zab.romik.system.ExceptionContainer;


/**
 *
 *
 */
@ControllerAdvice(annotations = RestController.class)
public class AdviceController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RestResourceNotFoundException.class)
    public Class<ExceptionContainer> renderErrorPage() {
        return ExceptionContainer.class;
    }

    @ExceptionHandler(RestResourceNotFoundException.class)
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "This should be application specific";
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
}
