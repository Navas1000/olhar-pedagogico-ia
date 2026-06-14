package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.DiarioEducacionalDTO;
import br.com.olharpedagogicoia.application.exceptions.DiarioEducacionalNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.out.ConsultarDiarioEducacionalPortOut;
import br.com.olharpedagogicoia.application.stub.DiarioEducacionalStub;
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
public class ConsultarDiarioEducacionalUseCaseTest {

    @Mock
    private ConsultarDiarioEducacionalPortOut consultarDiarioEducacionalPortOut;

    @InjectMocks
    private ConsultarDiarioEducacionalUseCase consultarDiarioEducacionalUseCase;

    @Test
    void deveConsultarDiarioEducacionalDto() throws DiarioEducacionalNaoEncontradoException {

        final DiarioEducacionalDTO diarioEducacionalConsultado =
                DiarioEducacionalStub.getDiarioEducacionalCompleta();

        when(consultarDiarioEducacionalPortOut.consultar(diarioEducacionalConsultado.getIdDiario()))
                .thenReturn(diarioEducacionalConsultado);

        assertDoesNotThrow(() ->
                consultarDiarioEducacionalUseCase.consultar(diarioEducacionalConsultado.getIdDiario())
        );

        verify(consultarDiarioEducacionalPortOut).consultar(anyInt());
    }
}