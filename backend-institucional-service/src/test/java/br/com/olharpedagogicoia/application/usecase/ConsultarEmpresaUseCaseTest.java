package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.EmpresaDto;
import br.com.olharpedagogicoia.application.exceptions.EmpresaNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.out.ConsultarEmpresaPortOut;
import br.com.olharpedagogicoia.application.stub.EmpresaStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ConsultarEmpresaUseCaseTest {

    @Mock
    private ConsultarEmpresaPortOut consultarEmpresaPortOut;

    @InjectMocks
    private ConsultarEmpresaUseCase consultarEmpresaUseCase;

    @Test
    void deveConsultarEmpresaDto() throws EmpresaNaoEncontradaException {

        final EmpresaDto empresaConsultada = EmpresaStub.getEmpresaCompleta();

        when(consultarEmpresaPortOut.consultar(empresaConsultada.getIdEmpresa())).thenReturn(empresaConsultada);

        assertDoesNotThrow(() -> consultarEmpresaUseCase.consultar(empresaConsultada.getIdEmpresa()));

        verify(consultarEmpresaPortOut).consultar(anyInt());
    }
}