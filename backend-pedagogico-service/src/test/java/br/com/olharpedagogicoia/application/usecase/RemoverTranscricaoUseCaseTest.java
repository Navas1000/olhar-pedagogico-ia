package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.exceptions.TranscricaoNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.out.RemoverTranscricaoPortOut;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class RemoverTranscricaoUseCaseTest {

    @Mock
    private RemoverTranscricaoPortOut removerTranscricaoPortOut;

    @InjectMocks
    private RemoverTranscricaoUseCase removerTranscricaoUseCase;

    @Test
    void deveRemoverTranscricao() throws TranscricaoNaoEncontradaException {

        assertDoesNotThrow(() ->
                removerTranscricaoUseCase.remover(1)
        );

        verify(removerTranscricaoPortOut).remover(anyInt());
    }
}