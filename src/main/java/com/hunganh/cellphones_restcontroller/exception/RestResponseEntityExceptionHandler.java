//package com.hunganh.cellphones_restcontroller.exception;
//
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//import javax.persistence.EntityNotFoundException;
//
//@ControllerAdvice
//public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
//    public RestResponseEntityExceptionHandler() {
//        super();
//    }
//
//    // 404
//    @ExceptionHandler(value = { EntityNotFoundException.class, ResourceNotFoundException.class })
//    protected ResponseEntity<Object> handleNotFound(final RuntimeException ex, final WebRequest request) {
//        return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
//    }
//
//    @ExceptionHandler(value = Exception.class)
//    protected ResponseEntity<Object> rootHandleError(final RuntimeException ex, final WebRequest request) {
//        return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
//    }
//}
