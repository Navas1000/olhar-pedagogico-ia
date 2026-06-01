package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.AlunoDTO;
import br.com.olharpedagogicoia.application.exceptions.AlunoNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.out.ConsultarAlunoPortOut;
import br.com.olharpedagogicoia.application.stub.AlunoStub;
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
public class ConsultarAlunoUseCaseTest {

    @Mock
    private ConsultarAlunoPortOut consultarAlunoPortOut;

    @InjectMocks
    private ConsultarAlunoUseCase consultarAlunoUseCase;

    @Test
    void deveConsultarAlunoDto() throws AlunoNaoEncontradoException {

        final AlunoDTO alunoConsultado = AlunoStub.getAlunoCompleta();

        when(consultarAlunoPortOut.consultar(alunoConsultado.getIdAluno()))
                .thenReturn(alunoConsultado);

        assertDoesNotThrow(() ->
                consultarAlunoUseCase.consultar(alunoConsultado.getIdAluno())
        );

        verify(consultarAlunoPortOut).consultar(anyInt());
    }
}