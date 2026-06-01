package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.exceptions.PapelFuncaoNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.out.RemoverPapelFuncaoPortOut;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class RemoverPapelFuncaoUseCaseTest {

    @Mock
    private RemoverPapelFuncaoPortOut removerPapelFuncaoPortOut;

    @InjectMocks
    private RemoverPapelFuncaoUseCase removerPapelFuncaoUseCase;

    @Test
    void deveRemoverPapelFuncao() throws PapelFuncaoNaoEncontradoException {

        assertDoesNotThrow(() -> removerPapelFuncaoUseCase.remover(1));

        verify(removerPapelFuncaoPortOut).remover(anyInt());
    }
}