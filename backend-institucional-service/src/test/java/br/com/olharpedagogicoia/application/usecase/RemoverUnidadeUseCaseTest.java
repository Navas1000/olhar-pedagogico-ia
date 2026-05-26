package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.exceptions.UnidadeNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.out.RemoverUnidadePortOut;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class RemoverUnidadeUseCaseTest {

    @Mock
    private RemoverUnidadePortOut removerUnidadePortOut;

    @InjectMocks
    private RemoverUnidadeUseCase removerUnidadeUseCase;

    @Test
    void deveRemoverUnidade() throws UnidadeNaoEncontradaException {

        assertDoesNotThrow(() -> removerUnidadeUseCase.remover(1));

        verify(removerUnidadePortOut).remover(anyInt());
    }
}