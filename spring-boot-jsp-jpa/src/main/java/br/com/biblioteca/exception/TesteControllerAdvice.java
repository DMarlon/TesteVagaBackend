package br.com.biblioteca.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class TesteControllerAdvice {

	@ExceptionHandler(value = RequiredFieldException.class)
	public ModelAndView duplicateBookException(RequiredFieldException exception) {
		final ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", exception.getMessage());
		modelAndView.setViewName("error-teste");
		return modelAndView;
	}
}