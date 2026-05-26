package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.UnidadeDto;
import br.com.olharpedagogicoia.application.port.out.CadastrarUnidadePortOut;
import br.com.olharpedagogicoia.application.stub.UnidadeStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CadastrarUnidadeUseCaseTest {

    @Mock
    private CadastrarUnidadePortOut cadastrarUnidadePortOut;

    @InjectMocks
    private CadastrarUnidadeUseCase cadastrarUnidadeUseCase;

    @Test
    void deveCadastrarUnidadeDto() {

        final UnidadeDto unidadeASerCadastrada = UnidadeStub.getUnidadeCadastrar();

        assertDoesNotThrow(() -> cadastrarUnidadeUseCase.cadastrar(unidadeASerCadastrada));

        assertNotNull(unidadeASerCadastrada.getDataCriacao());
        assertNotNull(unidadeASerCadastrada.getDataModificacao());

        verify(cadastrarUnidadePortOut).cadastrar(unidadeASerCadastrada);
    }
}