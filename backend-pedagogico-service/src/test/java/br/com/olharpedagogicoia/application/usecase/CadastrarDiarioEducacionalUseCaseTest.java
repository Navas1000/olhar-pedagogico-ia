package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.DiarioEducacionalDTO;
import br.com.olharpedagogicoia.application.port.out.CadastrarDiarioEducacionalPortOut;
import br.com.olharpedagogicoia.application.stub.DiarioEducacionalStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CadastrarDiarioEducacionalUseCaseTest {

    @Mock
    private CadastrarDiarioEducacionalPortOut cadastrarDiarioEducacionalPortOut;

    @InjectMocks
    private CadastrarDiarioEducacionalUseCase cadastrarDiarioEducacionalUseCase;

    @Test
    void deveCadastrarDiarioEducacionalDto() {

        final DiarioEducacionalDTO diarioEducacionalASerCadastrado =
                DiarioEducacionalStub.getDiarioEducacionalCadastrar();

        assertDoesNotThrow(() ->
                cadastrarDiarioEducacionalUseCase.cadastrar(diarioEducacionalASerCadastrado)
        );

        assertNotNull(diarioEducacionalASerCadastrado.getDataCriacao());

        verify(cadastrarDiarioEducacionalPortOut).cadastrar(diarioEducacionalASerCadastrado);
    }
}