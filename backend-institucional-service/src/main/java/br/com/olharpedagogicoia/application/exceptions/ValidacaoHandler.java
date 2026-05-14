package br.com.olharpedagogicoia.application.exceptions;


import br.com.olharpedagogicoia.application.dto.ErroValidacaoDto;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ValidacaoHandler {


    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErroValidacaoDto> handle(final MethodArgumentNotValidException exception) {
        final List<ErroValidacaoDto> dto = new ArrayList<>();

        final List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        fieldErrors.forEach(e -> {
            final ErroValidacaoDto erro = new ErroValidacaoDto(e.getField(), e.getDefaultMessage());
            dto.add(erro);
        });
        return dto;
    }
}
