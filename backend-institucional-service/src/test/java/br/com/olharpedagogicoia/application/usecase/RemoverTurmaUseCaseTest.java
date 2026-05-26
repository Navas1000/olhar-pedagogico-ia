package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.exceptions.TurmaNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.out.RemoverTurmaPortOut;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class RemoverTurmaUseCaseTest {

    @Mock
    private RemoverTurmaPortOut removerTurmaPortOut;

    @InjectMocks
    private RemoverTurmaUseCase removerTurmaUseCase;

    @Test
    void deveRemoverTurma() throws TurmaNaoEncontradaException {

        assertDoesNotThrow(() -> removerTurmaUseCase.remover(1));

        verify(removerTurmaPortOut).remover(anyInt());
    }
}