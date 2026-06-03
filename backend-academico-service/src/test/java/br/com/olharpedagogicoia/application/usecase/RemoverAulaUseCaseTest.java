package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.exceptions.AulaNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.out.RemoverAulaPortOut;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class RemoverAulaUseCaseTest {

    @Mock
    private RemoverAulaPortOut removerAulaPortOut;

    @InjectMocks
    private RemoverAulaUseCase removerAulaUseCase;

    @Test
    void deveRemoverAula() throws AulaNaoEncontradaException {

        assertDoesNotThrow(() -> removerAulaUseCase.remover(1));

        verify(removerAulaPortOut).remover(anyInt());
    }
}