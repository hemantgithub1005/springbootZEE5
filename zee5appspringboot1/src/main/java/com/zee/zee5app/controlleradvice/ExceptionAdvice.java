package com.zee.zee5app.controlleradvice;

import java.util.HashMap;

import javax.validation.Constraint;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;

@ControllerAdvice
public class ExceptionAdvice extends ResponseEntityExceptionHandler {
	//this class should be used if any exception is called through out all the controller
	
	@ExceptionHandler(AlreadyExistsException.class)
	public ResponseEntity<?>alreadyExistsExceptionHandler(AlreadyExistsException e)
	{
		HashMap<String,String>map=new HashMap();
		map.put("message","Record already exists"+e.getMessage());
		
		return ResponseEntity.badRequest().body(map);
	}
	
	
	
	
	
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<?>exceptionHandler(Exception e)
//	{
//		HashMap<String,String>map=new HashMap();
//		map.put("message","unknown exception"+e.getMessage());
//		
//		return ResponseEntity.badRequest().body(map);
//	}
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<?>idNotFoundExceptionHandler(IdNotFoundException e)
	{
		HashMap<String,String>map=new HashMap();
		map.put("message","IdNotFoundException"+e.getMessage());
		
		return ResponseEntity.badRequest().body(map);
	}
	
	
//	@Override
//	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//			HttpHeaders headers, HttpStatus status, WebRequest request) {
//		// TODO Auto-generated method stub
//		ApiError apiError=new ApiError(HttpStatus.BAD_REQUEST);
//		
//		apiError.setMessage("validation error");
//		apiError.addValidationErrors(ex.getBindingResult().getFieldErrors());
//		apiError.addValidationError(ex.getBindingResult().getGlobalErrors());
//		return buildResponseEntity(apiError);
//		
//		
//	}
//	
//	private ResponseEntity<Object> buildResponseEntity(ApiError apiError)
//	{
//		return new ResponseEntity<>(apiError,apiError.getHttpStatus());
//		
//	} 
//	
//	
//	@ExceptionHandler(ConstraintViolationException.class)
//	protected ResponseEntity<?> handleConstraintViolation() {
//		
//		return null;
//	}
//	
	

}
