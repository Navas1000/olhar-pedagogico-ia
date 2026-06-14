package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.ResumoEducacionalDTO;
import br.com.olharpedagogicoia.application.port.out.CadastrarResumoEducacionalPortOut;
import br.com.olharpedagogicoia.application.stub.ResumoEducacionalStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CadastrarResumoEducacionalUseCaseTest {

    @Mock
    private CadastrarResumoEducacionalPortOut cadastrarResumoEducacionalPortOut;

    @InjectMocks
    private CadastrarResumoEducacionalUseCase cadastrarResumoEducacionalUseCase;

    @Test
    void deveCadastrarResumoEducacionalDto() {

        final ResumoEducacionalDTO resumoEducacionalASerCadastrado =
                ResumoEducacionalStub.getResumoEducacionalCadastrar();

        assertDoesNotThrow(() ->
                cadastrarResumoEducacionalUseCase.cadastrar(resumoEducacionalASerCadastrado)
        );

        assertNotNull(resumoEducacionalASerCadastrado.getDataCriacao());

        verify(cadastrarResumoEducacionalPortOut).cadastrar(resumoEducacionalASerCadastrado);
    }
}