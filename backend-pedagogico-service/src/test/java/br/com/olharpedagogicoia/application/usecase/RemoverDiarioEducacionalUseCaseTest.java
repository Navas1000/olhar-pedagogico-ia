package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.exceptions.DiarioEducacionalNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.out.RemoverDiarioEducacionalPortOut;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class RemoverDiarioEducacionalUseCaseTest {

    @Mock
    private RemoverDiarioEducacionalPortOut removerDiarioEducacionalPortOut;

    @InjectMocks
    private RemoverDiarioEducacionalUseCase removerDiarioEducacionalUseCase;

    @Test
    void deveRemoverDiarioEducacional() throws DiarioEducacionalNaoEncontradoException {

        assertDoesNotThrow(() ->
                removerDiarioEducacionalUseCase.remover(1)
        );

        verify(removerDiarioEducacionalPortOut).remover(anyInt());
    }
}