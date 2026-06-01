package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.PessoaDTO;
import br.com.olharpedagogicoia.application.port.out.CadastrarPessoaPortOut;
import br.com.olharpedagogicoia.application.stub.PessoaStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CadastrarPessoaUseCaseTest {

    @Mock
    private CadastrarPessoaPortOut cadastrarPessoaPortOut;

    @InjectMocks
    private CadastrarPessoaUseCase cadastrarPessoaUseCase;

    @Test
    void deveCadastrarPessoaDto() {

        final PessoaDTO pessoaASerCadastrada = PessoaStub.getPessoaCadastrar();

        assertDoesNotThrow(() ->
                cadastrarPessoaUseCase.cadastrar(pessoaASerCadastrada)
        );

        assertNotNull(pessoaASerCadastrada.getDataCriacao());
        assertNotNull(pessoaASerCadastrada.getDataModificacao());

        verify(cadastrarPessoaPortOut).cadastrar(pessoaASerCadastrada);
    }
}