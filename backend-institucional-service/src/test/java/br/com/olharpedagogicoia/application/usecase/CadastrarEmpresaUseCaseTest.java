package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.EmpresaDto;
import br.com.olharpedagogicoia.application.port.out.CadastrarEmpresaPortOut;
import br.com.olharpedagogicoia.application.stub.EmpresaStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CadastrarEmpresaUseCaseTest {

    @Mock
    private CadastrarEmpresaPortOut cadastrarEmpresaPortOut;

    @InjectMocks
    private CadastrarEmpresaUseCase cadastrarEmpresaUseCase;

    @Test
    void deveCadastrarEmpresaDto() {

        final EmpresaDto empresaASerCadastrada = EmpresaStub.getEmpresaCadastrar();

        assertDoesNotThrow(() -> cadastrarEmpresaUseCase.cadastrar(empresaASerCadastrada));

        assertNotNull(empresaASerCadastrada.getDataCriacao());
        assertNotNull(empresaASerCadastrada.getDataModificacao());

        verify(cadastrarEmpresaPortOut).cadastrar(empresaASerCadastrada);
    }
}