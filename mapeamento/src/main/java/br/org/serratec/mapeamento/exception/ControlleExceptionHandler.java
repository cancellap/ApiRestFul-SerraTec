package br.org.serratec.mapeamento.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControlleExceptionHandler  extends ResponseEntityExceptionHandler{

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exe,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		List<String> erros = new ArrayList<String>();
		for (FieldError fe : exe.getBindingResult().getFieldErrors()) {
			erros.add(fe.getField()+": "+ fe.getDefaultMessage());
		}
		
		//Override no metodo, retorno o "ErroResponse" dentro dele
		ErrorResponse error = new ErrorResponse(status.value(), "Existem campos invalidos", LocalDateTime.now(), erros);
		return super.handleExceptionInternal(exe, error, headers, status, request);
	}
	
}
