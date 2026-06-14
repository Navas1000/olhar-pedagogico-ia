package br.com.olharpedagogicoia.application.exceptions;

import br.com.olharpedagogicoia.application.dto.ErroValidacaoDto;
import org.junit.jupiter.api.Test;
import org.springframework.core.MethodParameter;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Method;
import java.util.List;

public class ValidacaoHandlerTest {

    @Test
    void deveTratarCorretamenteAExcecao() throws NoSuchMethodException {

        final MethodParameter parametroMetodo = new MethodParameter(Object.class.getMethod("toString"), -1);
        final Object objetoTeste = new Object();
        final DataBinder ligacaoDados = new DataBinder(objetoTeste);
        final BindingResult resultadoLigacao = ligacaoDados.getBindingResult();
        final FieldError erroAtributo = new FieldError("Teste", "teste", "teste");
        resultadoLigacao.addError(erroAtributo);
        final MethodArgumentNotValidException excecao = new MethodArgumentNotValidException(parametroMetodo, resultadoLigacao);

        final ValidacaoHandler validacaoHandler = new ValidacaoHandler();
        List<ErroValidacaoDto> erroValidacaoDtoList = validacaoHandler.handle(excecao);


        assertNotNull(erroValidacaoDtoList);
        assertEquals(1, erroValidacaoDtoList.size());
        assertEquals("teste", erroValidacaoDtoList.get(0).campo());
        assertEquals("teste", erroValidacaoDtoList.get(0).mensagem());
    }

}
