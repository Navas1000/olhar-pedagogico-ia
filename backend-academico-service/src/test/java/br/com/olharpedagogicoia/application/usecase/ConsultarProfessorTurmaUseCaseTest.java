package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.ProfessorTurmaDTO;
import br.com.olharpedagogicoia.application.exceptions.ProfessorTurmaNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.out.ConsultarProfessorTurmaPortOut;
import br.com.olharpedagogicoia.application.stub.ProfessorTurmaStub;
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
public class ConsultarProfessorTurmaUseCaseTest {

    @Mock
    private ConsultarProfessorTurmaPortOut consultarProfessorTurmaPortOut;

    @InjectMocks
    private ConsultarProfessorTurmaUseCase consultarProfessorTurmaUseCase;

    @Test
    void deveConsultarProfessorTurmaDto() throws ProfessorTurmaNaoEncontradaException {

        final ProfessorTurmaDTO professorTurmaConsultado =
                ProfessorTurmaStub.getProfessorTurmaCompleta();

        when(consultarProfessorTurmaPortOut.consultar(professorTurmaConsultado.getIdAlocacao()))
                .thenReturn(professorTurmaConsultado);

        assertDoesNotThrow(() ->
                consultarProfessorTurmaUseCase.consultar(professorTurmaConsultado.getIdAlocacao())
        );

        verify(consultarProfessorTurmaPortOut).consultar(anyInt());
    }
}