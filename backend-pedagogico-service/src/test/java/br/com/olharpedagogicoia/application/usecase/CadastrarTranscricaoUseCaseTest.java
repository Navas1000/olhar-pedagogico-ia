package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.TranscricaoDTO;
import br.com.olharpedagogicoia.application.port.out.CadastrarTranscricaoPortOut;
import br.com.olharpedagogicoia.application.stub.TranscricaoStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CadastrarTranscricaoUseCaseTest {

    @Mock
    private CadastrarTranscricaoPortOut cadastrarTranscricaoPortOut;

    @InjectMocks
    private CadastrarTranscricaoUseCase cadastrarTranscricaoUseCase;

    @Test
    void deveCadastrarTranscricaoDto() {

        final TranscricaoDTO transcricaoASerCadastrada =
                TranscricaoStub.getTranscricaoCadastrar();

        assertDoesNotThrow(() ->
                cadastrarTranscricaoUseCase.cadastrar(transcricaoASerCadastrada)
        );

        assertNotNull(transcricaoASerCadastrada.getDataCriacao());

        verify(cadastrarTranscricaoPortOut).cadastrar(transcricaoASerCadastrada);
    }
}