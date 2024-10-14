package com.mehmett.arkadaslik_uygulamasi.exception;

import com.mehmett.arkadaslik_uygulamasi.dto.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
	
	/**
	 *Tanımlaması yapılmayan tüm istisnaları yakalamak için
	 */
//	@ExceptionHandler(RuntimeException.class)
//	public ResponseEntity<ErrorMessage> runtimeExceptionHandler(RuntimeException exception) {
//		return createResponseEntity(ErrorType.INTERNAL_SERVER_ERROR,HttpStatus.INTERNAL_SERVER_ERROR, null);
//	}
//
//	@ExceptionHandler(ArkadaslikException.class) //istisnayı yakalayan kısım
//	@ResponseBody
//	public ResponseEntity<ErrorMessage> ArkadaslikExceptionHandler(ArkadaslikException exception) {
//		// ResponseEntity.ok() -> 200 OK yani gelen istek basarılı Success herşey yolunda
//		// ResponseEntity.badRequest() -> 400 BadRequest yani gelen istek hatalı
//		// ResponseEntity.internalServerError() -> 500 sunucu tarafında hata oluştu
//		return createResponseEntity(exception.getErrorType(),exception.getErrorType().getHttpStatus(),null);
//	}
//
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	@ResponseBody
//	public ResponseEntity<ErrorMessage> methodArgumentNotValidException(MethodArgumentNotValidException exception) {
//		List<String> fieldsErrors = new ArrayList<>();
//				exception.getBindingResult().getFieldErrors()
//		                               .forEach(f ->{
//										   //f.getField()
//			                               //f.getDefaultMessage()
//			                               fieldsErrors.add("Değisken adı : "+f.getField() + " : " + " - Hata detayı : "+f.getDefaultMessage());
//		                               } );
//	 return createResponseEntity(ErrorType.VALIDATION_ERROR,HttpStatus.BAD_REQUEST,fieldsErrors);
//	}
//
//	public ResponseEntity<ErrorMessage> createResponseEntity(ErrorType errorType,HttpStatus httpStatus,List<String> fields) {
//		log.error("Tüm hataların geçtiği nokta .... : "+errorType.getMessage()+fields);
//		return new ResponseEntity<>(ErrorMessage.builder()
//				                            .fields(fields)
//		                                        .code(errorType.getCode())
//		                                        .message(errorType.getMessage())
//				                            .success(false)
//		                                        .build(), httpStatus);
//	}
	
	}