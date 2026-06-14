package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.exceptions.DiarioAudioNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.out.RemoverDiarioAudioPortOut;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class RemoverDiarioAudioUseCaseTest {

    @Mock
    private RemoverDiarioAudioPortOut removerDiarioAudioPortOut;

    @InjectMocks
    private RemoverDiarioAudioUseCase removerDiarioAudioUseCase;

    @Test
    void deveRemoverDiarioAudio() throws DiarioAudioNaoEncontradoException {

        assertDoesNotThrow(() ->
                removerDiarioAudioUseCase.remover(1)
        );

        verify(removerDiarioAudioPortOut).remover(anyInt());
    }
}