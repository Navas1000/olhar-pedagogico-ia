package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.exceptions.ResumoAudioNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.out.RemoverResumoAudioPortOut;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class RemoverResumoAudioUseCaseTest {

    @Mock
    private RemoverResumoAudioPortOut removerResumoAudioPortOut;

    @InjectMocks
    private RemoverResumoAudioUseCase removerResumoAudioUseCase;

    @Test
    void deveRemoverResumoAudio() throws ResumoAudioNaoEncontradoException {

        assertDoesNotThrow(() ->
                removerResumoAudioUseCase.remover(1)
        );

        verify(removerResumoAudioPortOut).remover(anyInt());
    }
}