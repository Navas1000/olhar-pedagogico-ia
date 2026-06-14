package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.DiarioAudioDTO;
import br.com.olharpedagogicoia.application.port.out.CadastrarDiarioAudioPortOut;
import br.com.olharpedagogicoia.application.stub.DiarioAudioStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CadastrarDiarioAudioUseCaseTest {

    @Mock
    private CadastrarDiarioAudioPortOut cadastrarDiarioAudioPortOut;

    @InjectMocks
    private CadastrarDiarioAudioUseCase cadastrarDiarioAudioUseCase;

    @Test
    void deveCadastrarDiarioAudioDto() {

        final DiarioAudioDTO diarioAudioASerCadastrado =
                DiarioAudioStub.getDiarioAudioCadastrar();

        assertDoesNotThrow(() ->
                cadastrarDiarioAudioUseCase.cadastrar(diarioAudioASerCadastrado)
        );

        assertNotNull(diarioAudioASerCadastrado.getDataCriacao());

        verify(cadastrarDiarioAudioPortOut).cadastrar(diarioAudioASerCadastrado);
    }
}