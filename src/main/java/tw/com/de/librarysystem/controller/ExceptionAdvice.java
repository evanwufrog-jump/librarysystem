package tw.com.de.librarysystem.controller;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.com.de.librarysystem.exception.TestException;
import tw.com.de.librarysystem.model.dto.ResponseDto;

@ControllerAdvice
public class ExceptionAdvice {
	private static final Logger logger = LogManager.getLogger(Exception.class);
	@ExceptionHandler(SQLException.class)
	@ResponseBody
	public ResponseDto handleSQLException(SQLException exception) {
		System.err.println("error!!! what's happen!!!!");
		logger.error(exception.getMessage(), exception);
		return ResponseDto.fail();
	}
	
	@ExceptionHandler(TestException.class)
	@ResponseBody
	public ResponseDto handleTestException(TestException exception) {
		System.err.println("test!!! what's happen!!!!");
		logger.error(exception.getMessage(), exception);
		return ResponseDto.fail();
	}
}
