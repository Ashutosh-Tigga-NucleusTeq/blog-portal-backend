package com.blog.portal.exception;

import com.blog.portal.exception.*;
import com.blog.portal.responsePayload.ResponseOutDTO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.HashMap;
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
        ResourceNotFoundException ex = new ResourceNotFoundException("Resource not found", "Resource", "123");
        ResponseEntity<ResponseOutDTO> response = globalExceptionHandler.resourceNotFoundExceptionHandler(ex);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Resource not found not found with Resource : 123", response.getBody().getMessage());
        assertEquals(false, response.getBody().isSuccess());
    }

    @Test
    public void testIllegalArgumentExceptionHandler() {
        IllegalArgumentException ex = new IllegalArgumentException("Illegal argument");
        ResponseEntity<ResponseOutDTO> response = globalExceptionHandler.resourceNotFoundExceptionHandler(ex);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Illegal argument", response.getBody().getMessage());
        assertEquals(false, response.getBody().isSuccess());
    }

    @Test
    public void testHttpMessageNotReadableExceptionHandler() {
        HttpMessageNotReadableException ex = new HttpMessageNotReadableException("Message not readable");
        ResponseEntity<ResponseOutDTO> response = globalExceptionHandler.resourceNotFoundExceptionHandler(ex);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Message not readable", response.getBody().getMessage());
        assertEquals(false, response.getBody().isSuccess());
    }

    @Test
    public void testUserAlreadyExistsExceptionHandler() {
        UserAlreadyExistsException ex = new UserAlreadyExistsException("User already exists");
        ResponseEntity<ResponseOutDTO> response = globalExceptionHandler.handleRegistrationException(ex);

        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
        assertEquals("User already exists", response.getBody().getMessage());
        assertEquals(false, response.getBody().isSuccess());
    }

    @Test
    public void testUnauthorizedUserExceptionHandler() {
        UnauthorizedUserExeption ex = new UnauthorizedUserExeption("Unauthorized user");
        ResponseEntity<ResponseOutDTO> response = globalExceptionHandler.handleUnauthorizedUserException(ex);

        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
        assertEquals("Unauthorized user", response.getBody().getMessage());
        assertEquals(false, response.getBody().isSuccess());
    }
}
