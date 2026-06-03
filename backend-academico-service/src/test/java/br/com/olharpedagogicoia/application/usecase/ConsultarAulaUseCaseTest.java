package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.AulaDTO;
import br.com.olharpedagogicoia.application.exceptions.AulaNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.out.ConsultarAulaPortOut;
import br.com.olharpedagogicoia.application.stub.AulaStub;
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
public class ConsultarAulaUseCaseTest {

    @Mock
    private ConsultarAulaPortOut consultarAulaPortOut;

    @InjectMocks
    private ConsultarAulaUseCase consultarAulaUseCase;

    @Test
    void deveConsultarAulaDto() throws AulaNaoEncontradaException {

        final AulaDTO aulaConsultada = AulaStub.getAulaCompleta();

        when(consultarAulaPortOut.consultar(aulaConsultada.getIdAula()))
                .thenReturn(aulaConsultada);

        assertDoesNotThrow(() ->
                consultarAulaUseCase.consultar(aulaConsultada.getIdAula())
        );

        verify(consultarAulaPortOut).consultar(anyInt());
    }
}