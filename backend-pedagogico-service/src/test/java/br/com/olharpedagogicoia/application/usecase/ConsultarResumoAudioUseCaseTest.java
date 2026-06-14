package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.ResumoAudioDTO;
import br.com.olharpedagogicoia.application.exceptions.ResumoAudioNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.out.ConsultarResumoAudioPortOut;
import br.com.olharpedagogicoia.application.stub.ResumoAudioStub;
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
public class ConsultarResumoAudioUseCaseTest {

    @Mock
    private ConsultarResumoAudioPortOut consultarResumoAudioPortOut;

    @InjectMocks
    private ConsultarResumoAudioUseCase consultarResumoAudioUseCase;

    @Test
    void deveConsultarResumoAudioDto() throws ResumoAudioNaoEncontradoException {

        final ResumoAudioDTO resumoAudioConsultado =
                ResumoAudioStub.getResumoAudioCompleta();

        when(consultarResumoAudioPortOut.consultar(resumoAudioConsultado.getIdAudio()))
                .thenReturn(resumoAudioConsultado);

        assertDoesNotThrow(() ->
                consultarResumoAudioUseCase.consultar(resumoAudioConsultado.getIdAudio())
        );

        verify(consultarResumoAudioPortOut).consultar(anyInt());
    }
}