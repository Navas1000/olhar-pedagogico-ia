package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.PapelFuncaoDTO;
import br.com.olharpedagogicoia.application.port.out.CadastrarPapelFuncaoPortOut;
import br.com.olharpedagogicoia.application.stub.PapelFuncaoStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CadastrarPapelFuncaoUseCaseTest {

    @Mock
    private CadastrarPapelFuncaoPortOut cadastrarPapelFuncaoPortOut;

    @InjectMocks
    private CadastrarPapelFuncaoUseCase cadastrarPapelFuncaoUseCase;

    @Test
    void deveCadastrarPapelFuncaoDto() {

        final PapelFuncaoDTO papelFuncaoASerCadastrado =
                PapelFuncaoStub.getPapelFuncaoCadastrar();

        assertDoesNotThrow(() ->
                cadastrarPapelFuncaoUseCase.cadastrar(papelFuncaoASerCadastrado)
        );

        assertNotNull(papelFuncaoASerCadastrado.getDataCriacao());
        assertNotNull(papelFuncaoASerCadastrado.getDataModificacao());

        verify(cadastrarPapelFuncaoPortOut).cadastrar(papelFuncaoASerCadastrado);
    }
}