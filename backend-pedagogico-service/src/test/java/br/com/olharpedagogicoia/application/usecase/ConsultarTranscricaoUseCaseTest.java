package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.TranscricaoDTO;
import br.com.olharpedagogicoia.application.exceptions.TranscricaoNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.out.ConsultarTranscricaoPortOut;
import br.com.olharpedagogicoia.application.stub.TranscricaoStub;
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
public class ConsultarTranscricaoUseCaseTest {

    @Mock
    private ConsultarTranscricaoPortOut consultarTranscricaoPortOut;

    @InjectMocks
    private ConsultarTranscricaoUseCase consultarTranscricaoUseCase;

    @Test
    void deveConsultarTranscricaoDto() throws TranscricaoNaoEncontradaException {

        final TranscricaoDTO transcricaoConsultada =
                TranscricaoStub.getTranscricaoCompleta();

        when(consultarTranscricaoPortOut.consultar(transcricaoConsultada.getIdTranscricao()))
                .thenReturn(transcricaoConsultada);

        assertDoesNotThrow(() ->
                consultarTranscricaoUseCase.consultar(transcricaoConsultada.getIdTranscricao())
        );

        verify(consultarTranscricaoPortOut).consultar(anyInt());
    }
}