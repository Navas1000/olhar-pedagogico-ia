package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.exceptions.ResumoEducacionalNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.out.RemoverResumoEducacionalPortOut;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class RemoverResumoEducacionalUseCaseTest {

    @Mock
    private RemoverResumoEducacionalPortOut removerResumoEducacionalPortOut;

    @InjectMocks
    private RemoverResumoEducacionalUseCase removerResumoEducacionalUseCase;

    @Test
    void deveRemoverResumoEducacional() throws ResumoEducacionalNaoEncontradoException {

        assertDoesNotThrow(() ->
                removerResumoEducacionalUseCase.remover(1)
        );

        verify(removerResumoEducacionalPortOut).remover(anyInt());
    }
}