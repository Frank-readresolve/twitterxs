package fr.formation.twitterxs.controllers;

import java.util.*;

import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.core.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import fr.formation.twitterxs.errors.*;
import fr.formation.twitterxs.security.Principal;

/**
 * A base abstract controller to be extended by concrete controllers.
 * <p>
 * This base controller overrides the
 * {@linkplain #handleMethodArgumentNotValid(MethodArgumentNotValidException, HttpHeaders, HttpStatus, WebRequest)
 * method argument not valid handler} and provides convenient methods such as
 * dealing with the authenticated user.
 */
public abstract class BaseController extends ResponseEntityExceptionHandler {

    protected BaseController() {
	// Empty default constructor
    }

    protected static Long getUserId() {
	return getPrincipal().getUserId();
    }

    protected static Principal getPrincipal() {
	return (Principal) getAuthentication().getPrincipal();
    }

    protected static Collection<? extends GrantedAuthority> getAuthorities() {
	return getAuthentication().getAuthorities();
    }

    protected static Authentication getAuthentication() {
	return SecurityContextHolder.getContext().getAuthentication();
    }

    @SuppressWarnings("unused")
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
	    MethodArgumentNotValidException ex, HttpHeaders headers,
	    HttpStatus status, WebRequest request) {
	// Intercept field errors
	List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
	List<ValidationError> errors = new ArrayList<>(fieldErrors.size());
	ValidationError error = null;
	for (FieldError fieldError : fieldErrors) {
	    String entityName = fieldError.getObjectName();
	    String fieldName = fieldError.getField();
	    String errorCode = fieldError.getDefaultMessage();
	    error = ValidationError.ofFieldType(entityName, fieldName,
		    errorCode);
	    errors.add(error);
	}
	// Intercept global errors such as multi-fields errors
	List<ObjectError> globalErrors = ex.getBindingResult()
		.getGlobalErrors();
	for (ObjectError globalError : globalErrors) {
	    String entityName = globalError.getObjectName();
	    String fieldName = globalError.getCode();
	    String errorCode = globalError.getDefaultMessage();
	    error = ValidationError.ofGlobalType(entityName, fieldName,
		    errorCode);
	    errors.add(error); // Merge field and global errors
	}
	ApiErrors<ValidationError> apiErrors = new ApiErrors<>(errors,
		status.value(), getRequestURI());
	return new ResponseEntity<>(apiErrors, status);
    }

    @SuppressWarnings("unused")
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(
	    HttpMessageNotReadableException ex, HttpHeaders headers,
	    HttpStatus status, WebRequest request) {
	// Intercept not readable messages including conversion errors
	List<MessageNotReadableError> errors = new ArrayList<>();
	errors.add(new MessageNotReadableError(ex.getMessage()));
	ApiErrors<MessageNotReadableError> apiErrors = new ApiErrors<>(errors,
		status.value(), getRequestURI());
	return new ResponseEntity<>(apiErrors, status);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex,
	    Object body, HttpHeaders headers, HttpStatus status,
	    WebRequest request) {
	// Intercept any other exceptions
	return super.handleExceptionInternal(ex, body, headers, status,
		request);
    }

    /**
     * Convenient method returning the request URI.
     *
     * @return the request URI
     */
    protected static String getRequestURI() {
	ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder
		.currentRequestAttributes();
	return attr.getRequest().getRequestURI();
    }
}
