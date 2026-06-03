package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.AlunoTurmaDTO;
import br.com.olharpedagogicoia.application.exceptions.AlunoTurmaNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.out.ConsultarAlunoTurmaPortOut;
import br.com.olharpedagogicoia.application.stub.AlunoTurmaStub;
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
public class ConsultarAlunoTurmaUseCaseTest {

    @Mock
    private ConsultarAlunoTurmaPortOut consultarAlunoTurmaPortOut;

    @InjectMocks
    private ConsultarAlunoTurmaUseCase consultarAlunoTurmaUseCase;

    @Test
    void deveConsultarAlunoTurmaDto() throws AlunoTurmaNaoEncontradaException {

        final AlunoTurmaDTO alunoTurmaConsultado = AlunoTurmaStub.getAlunoTurmaCompleta();

        when(consultarAlunoTurmaPortOut.consultar(alunoTurmaConsultado.getIdMatricula()))
                .thenReturn(alunoTurmaConsultado);

        assertDoesNotThrow(() ->
                consultarAlunoTurmaUseCase.consultar(alunoTurmaConsultado.getIdMatricula())
        );

        verify(consultarAlunoTurmaPortOut).consultar(anyInt());
    }
}