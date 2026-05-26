package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.TurmaDto;
import br.com.olharpedagogicoia.application.exceptions.TurmaNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.out.ConsultarTurmaPortOut;
import br.com.olharpedagogicoia.application.stub.TurmaStub;
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
public class ConsultarTurmaUseCaseTest {

    @Mock
    private ConsultarTurmaPortOut consultarTurmaPortOut;

    @InjectMocks
    private ConsultarTurmaUseCase consultarTurmaUseCase;

    @Test
    void deveConsultarTurmaDto() throws TurmaNaoEncontradaException {

        final TurmaDto turmaConsultada = TurmaStub.getTurmaCompleta();

        when(consultarTurmaPortOut.consultar(turmaConsultada.getIdTurma())).thenReturn(turmaConsultada);

        assertDoesNotThrow(() -> consultarTurmaUseCase.consultar(turmaConsultada.getIdTurma()));

        verify(consultarTurmaPortOut).consultar(anyInt());
    }
}