package com.blog.portal.exception;

import com.blog.portal.exception.*;
import com.blog.portal.responsePayload.ResponseOutDTO;
import com.blog.portal.util.Constants;
import com.blog.portal.util.ErrorConstants;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GlobalExceptionHandlerTest {

    @InjectMocks
    private GlobalExceptionHandler globalExceptionHandler;

    @Mock
    private MethodArgumentNotValidException methodArgumentNotValidException;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testResourceNotFoundExceptionHandler() {
    		String className = Constants.POST_CLASS_NAME;
    		String fieldName = Constants.POST_ID;
    		String fieldValue = "postId";
        ResourceNotFoundException ex = new ResourceNotFoundException(className, fieldName, fieldValue);
        ResponseEntity<ResponseOutDTO> response = globalExceptionHandler.resourceNotFoundExceptionHandler(ex);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testIllegalArgumentExceptionHandler() {
    	String message = "Illegal argument";
        IllegalArgumentException ex = new IllegalArgumentException(message);
        ResponseEntity<ResponseOutDTO> response = globalExceptionHandler.resourceNotFoundExceptionHandler(ex);
        assertEquals(message, response.getBody().getMessage());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }

    @Test
    public void testHttpMessageNotReadableExceptionHandler() {
    		String message = "Message not readable";
        HttpMessageNotReadableException ex = new HttpMessageNotReadableException(message);
        ResponseEntity<ResponseOutDTO> response = globalExceptionHandler.resourceNotFoundExceptionHandler(ex);
        assertEquals(message, response.getBody().getMessage());
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void testUserAlreadyExistsExceptionHandler() {
        BadRequestException ex = new BadRequestException(ErrorConstants.EMAIL_ALREADY_EXISTS);
        ResponseEntity<ResponseOutDTO> response = globalExceptionHandler.handleRegistrationException(ex);
        assertEquals(ErrorConstants.EMAIL_ALREADY_EXISTS, response.getBody().getMessage());
        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
    }

    @Test
    public void testUnauthorizedUserExceptionHandler() {
        UnauthorizedUserExeption ex = new UnauthorizedUserExeption(ErrorConstants.UNAUTHORIZED_USER);
        ResponseEntity<ResponseOutDTO> response = globalExceptionHandler.handleUnauthorizedUserException(ex);

        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
        assertEquals(ErrorConstants.UNAUTHORIZED_USER, response.getBody().getMessage());
    }
    
    @Test
    public void testEmptyDataExceptionHandler() {
    	EmptyDataException ex = new EmptyDataException(ErrorConstants.EMPTY_BLOG);
    	ResponseEntity<ResponseOutDTO> response = globalExceptionHandler.handleEmptyDataException(ex);
    	assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    	assertEquals(ErrorConstants.EMPTY_BLOG, response.getBody().getMessage());
    }
    
    @Test
    public void testHandleMethodArgsNotValidException() {
        MethodArgumentNotValidException ex = mock(MethodArgumentNotValidException.class);
        BindingResult bindingResult = mock(BindingResult.class);
        FieldError fieldError1 = new FieldError("objectName", "field1", "Error message 1");
        FieldError fieldError2 = new FieldError("objectName", "field2", "Error message 2");


    }
}
