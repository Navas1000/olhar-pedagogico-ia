package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.exceptions.FuncionarioNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.out.RemoverFuncionarioPortOut;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class RemoverFuncionarioUseCaseTest {

    @Mock
    private RemoverFuncionarioPortOut removerFuncionarioPortOut;

    @InjectMocks
    private RemoverFuncionarioUseCase removerFuncionarioUseCase;

    @Test
    void deveRemoverFuncionario() throws FuncionarioNaoEncontradoException {

        assertDoesNotThrow(() -> removerFuncionarioUseCase.remover(1));

        verify(removerFuncionarioPortOut).remover(anyInt());
    }
}