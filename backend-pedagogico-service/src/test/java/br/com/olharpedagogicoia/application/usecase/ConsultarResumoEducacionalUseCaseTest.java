package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.ResumoEducacionalDTO;
import br.com.olharpedagogicoia.application.exceptions.ResumoEducacionalNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.out.ConsultarResumoEducacionalPortOut;
import br.com.olharpedagogicoia.application.stub.ResumoEducacionalStub;
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
public class ConsultarResumoEducacionalUseCaseTest {

    @Mock
    private ConsultarResumoEducacionalPortOut consultarResumoEducacionalPortOut;

    @InjectMocks
    private ConsultarResumoEducacionalUseCase consultarResumoEducacionalUseCase;

    @Test
    void deveConsultarResumoEducacionalDto() throws ResumoEducacionalNaoEncontradoException {

        final ResumoEducacionalDTO resumoEducacionalConsultado =
                ResumoEducacionalStub.getResumoEducacionalCompleta();

        when(consultarResumoEducacionalPortOut.consultar(resumoEducacionalConsultado.getIdResumo()))
                .thenReturn(resumoEducacionalConsultado);

        assertDoesNotThrow(() ->
                consultarResumoEducacionalUseCase.consultar(resumoEducacionalConsultado.getIdResumo())
        );

        verify(consultarResumoEducacionalPortOut).consultar(anyInt());
    }
}