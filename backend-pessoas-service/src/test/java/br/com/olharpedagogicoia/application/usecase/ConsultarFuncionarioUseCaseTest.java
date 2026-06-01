package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.FuncionarioDTO;
import br.com.olharpedagogicoia.application.exceptions.FuncionarioNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.out.ConsultarFuncionarioPortOut;
import br.com.olharpedagogicoia.application.stub.FuncionarioStub;
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
public class ConsultarFuncionarioUseCaseTest {

    @Mock
    private ConsultarFuncionarioPortOut consultarFuncionarioPortOut;

    @InjectMocks
    private ConsultarFuncionarioUseCase consultarFuncionarioUseCase;

    @Test
    void deveConsultarFuncionarioDto() throws FuncionarioNaoEncontradoException {

        final FuncionarioDTO funcionarioConsultado = FuncionarioStub.getFuncionarioCompleta();

        when(consultarFuncionarioPortOut.consultar(funcionarioConsultado.getIdFuncionario()))
                .thenReturn(funcionarioConsultado);

        assertDoesNotThrow(() ->
                consultarFuncionarioUseCase.consultar(funcionarioConsultado.getIdFuncionario())
        );

        verify(consultarFuncionarioPortOut).consultar(anyInt());
    }
}