package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.ResumoAudioDTO;
import br.com.olharpedagogicoia.application.port.out.CadastrarResumoAudioPortOut;
import br.com.olharpedagogicoia.application.stub.ResumoAudioStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CadastrarResumoAudioUseCaseTest {

    @Mock
    private CadastrarResumoAudioPortOut cadastrarResumoAudioPortOut;

    @InjectMocks
    private CadastrarResumoAudioUseCase cadastrarResumoAudioUseCase;

    @Test
    void deveCadastrarResumoAudioDto() {

        final ResumoAudioDTO resumoAudioASerCadastrado =
                ResumoAudioStub.getResumoAudioCadastrar();

        assertDoesNotThrow(() ->
                cadastrarResumoAudioUseCase.cadastrar(resumoAudioASerCadastrado)
        );

        assertNotNull(resumoAudioASerCadastrado.getDataCriacao());

        verify(cadastrarResumoAudioPortOut).cadastrar(resumoAudioASerCadastrado);
    }
}