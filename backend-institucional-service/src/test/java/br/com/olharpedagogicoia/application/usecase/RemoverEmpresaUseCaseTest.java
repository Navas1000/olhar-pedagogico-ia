package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.exceptions.EmpresaNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.out.RemoverEmpresaPortOut;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RemoverEmpresaUseCaseTest {

    @Mock
    private RemoverEmpresaPortOut removerEmpresaPortOut;

    @InjectMocks
    private RemoverEmpresaUseCase removerEmpresaUseCase;

    @Test
    void deveRemoverEmpresa() throws EmpresaNaoEncontradaException {

        assertDoesNotThrow(() -> removerEmpresaUseCase.remover(1));

        verify(removerEmpresaPortOut).remover(anyInt());
    }

}