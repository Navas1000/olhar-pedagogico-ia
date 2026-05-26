package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.UnidadeDto;
import br.com.olharpedagogicoia.application.exceptions.UnidadeNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.out.ConsultarUnidadePortOut;
import br.com.olharpedagogicoia.application.stub.UnidadeStub;
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
public class ConsultarUnidadeUseCaseTest {

    @Mock
    private ConsultarUnidadePortOut consultarUnidadePortOut;

    @InjectMocks
    private ConsultarUnidadeUseCase consultarUnidadeUseCase;

    @Test
    void deveConsultarUnidadeDto() throws UnidadeNaoEncontradaException {

        final UnidadeDto unidadeConsultada = UnidadeStub.getUnidadeCompleta();

        when(consultarUnidadePortOut.consultar(unidadeConsultada.getIdUnidade())).thenReturn(unidadeConsultada);

        assertDoesNotThrow(() -> consultarUnidadeUseCase.consultar(unidadeConsultada.getIdUnidade()));

        verify(consultarUnidadePortOut).consultar(anyInt());
    }
}