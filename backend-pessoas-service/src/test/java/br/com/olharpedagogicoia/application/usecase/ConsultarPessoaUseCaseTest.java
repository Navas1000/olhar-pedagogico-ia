package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.PessoaDTO;
import br.com.olharpedagogicoia.application.exceptions.PessoaNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.out.ConsultarPessoaPortOut;
import br.com.olharpedagogicoia.application.stub.PessoaStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ConsultarPessoaUseCaseTest {

    @Mock
    private ConsultarPessoaPortOut consultarPessoaPortOut;

    @InjectMocks
    private ConsultarPessoaUseCase consultarPessoaUseCase;

    @Test
    void deveConsultarPessoaDto() throws PessoaNaoEncontradaException {

        final PessoaDTO pessoaConsultada = PessoaStub.getPessoaCompleta();

        when(consultarPessoaPortOut.consultar(pessoaConsultada.getIdPessoa()))
                .thenReturn(pessoaConsultada);

        assertDoesNotThrow(() ->
                consultarPessoaUseCase.consultar(pessoaConsultada.getIdPessoa())
        );

        verify(consultarPessoaPortOut).consultar(anyInt());
    }
}