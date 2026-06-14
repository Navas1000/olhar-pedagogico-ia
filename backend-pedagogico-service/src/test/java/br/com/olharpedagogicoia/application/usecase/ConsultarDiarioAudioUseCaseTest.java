package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.DiarioAudioDTO;
import br.com.olharpedagogicoia.application.exceptions.DiarioAudioNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.out.ConsultarDiarioAudioPortOut;
import br.com.olharpedagogicoia.application.stub.DiarioAudioStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ConsultarDiarioAudioUseCaseTest {

    @Mock
    private ConsultarDiarioAudioPortOut consultarDiarioAudioPortOut;

    @InjectMocks
    private ConsultarDiarioAudioUseCase consultarDiarioAudioUseCase;

    @Test
    void deveConsultarDiarioAudioDto() throws DiarioAudioNaoEncontradoException {

        final DiarioAudioDTO diarioAudioConsultado =
                DiarioAudioStub.getDiarioAudioCompleta();

        when(consultarDiarioAudioPortOut.consultar(diarioAudioConsultado.getIdAudio()))
                .thenReturn(diarioAudioConsultado);

        assertDoesNotThrow(() ->
                consultarDiarioAudioUseCase.consultar(diarioAudioConsultado.getIdAudio())
        );

        verify(consultarDiarioAudioPortOut).consultar(anyInt());
    }
}