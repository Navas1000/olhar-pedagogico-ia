package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.exceptions.PessoaNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.out.RemoverPessoaPortOut;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class RemoverPessoaUseCaseTest {

    @Mock
    private RemoverPessoaPortOut removerPessoaPortOut;

    @InjectMocks
    private RemoverPessoaUseCase removerPessoaUseCase;

    @Test
    void deveRemoverPessoa() throws PessoaNaoEncontradaException {

        assertDoesNotThrow(() -> removerPessoaUseCase.remover(1));

        verify(removerPessoaPortOut).remover(anyInt());
    }
}