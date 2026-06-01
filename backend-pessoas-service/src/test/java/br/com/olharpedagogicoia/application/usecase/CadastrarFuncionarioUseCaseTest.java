package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.FuncionarioDTO;
import br.com.olharpedagogicoia.application.port.out.CadastrarFuncionarioPortOut;
import br.com.olharpedagogicoia.application.stub.FuncionarioStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CadastrarFuncionarioUseCaseTest {

    @Mock
    private CadastrarFuncionarioPortOut cadastrarFuncionarioPortOut;

    @InjectMocks
    private CadastrarFuncionarioUseCase cadastrarFuncionarioUseCase;

    @Test
    void deveCadastrarFuncionarioDto() {

        final FuncionarioDTO funcionarioASerCadastrado =
                FuncionarioStub.getFuncionarioCadastrar();

        assertDoesNotThrow(() ->
                cadastrarFuncionarioUseCase.cadastrar(funcionarioASerCadastrado)
        );

        assertNotNull(funcionarioASerCadastrado.getDataCriacao());
        assertNotNull(funcionarioASerCadastrado.getDataModificacao());

        verify(cadastrarFuncionarioPortOut).cadastrar(funcionarioASerCadastrado);
    }
}