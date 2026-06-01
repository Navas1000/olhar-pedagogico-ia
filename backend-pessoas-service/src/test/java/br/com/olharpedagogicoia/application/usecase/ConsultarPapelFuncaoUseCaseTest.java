package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.PapelFuncaoDTO;
import br.com.olharpedagogicoia.application.exceptions.PapelFuncaoNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.out.ConsultarPapelFuncaoPortOut;
import br.com.olharpedagogicoia.application.stub.PapelFuncaoStub;
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
public class ConsultarPapelFuncaoUseCaseTest {

    @Mock
    private ConsultarPapelFuncaoPortOut consultarPapelFuncaoPortOut;

    @InjectMocks
    private ConsultarPapelFuncaoUseCase consultarPapelFuncaoUseCase;

    @Test
    void deveConsultarPapelFuncaoDto() throws PapelFuncaoNaoEncontradoException {

        final PapelFuncaoDTO papelFuncaoConsultado =
                PapelFuncaoStub.getPapelFuncaoCompleta();

        when(consultarPapelFuncaoPortOut.consultar(papelFuncaoConsultado.getIdPapel()))
                .thenReturn(papelFuncaoConsultado);

        assertDoesNotThrow(() ->
                consultarPapelFuncaoUseCase.consultar(papelFuncaoConsultado.getIdPapel())
        );

        verify(consultarPapelFuncaoPortOut).consultar(anyInt());
    }
}