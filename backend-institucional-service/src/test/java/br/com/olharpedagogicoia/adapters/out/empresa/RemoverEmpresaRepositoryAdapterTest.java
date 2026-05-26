package br.com.olharpedagogicoia.adapters.out.empresa;

import br.com.olharpedagogicoia.adapters.out.empresa.entity.EmpresaEntity;
import br.com.olharpedagogicoia.adapters.out.empresa.repository.EmpresaRepository;
import br.com.olharpedagogicoia.application.exceptions.EmpresaNaoEncontradaException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RemoverEmpresaRepositoryAdapterTest {

    @Mock
    private EmpresaRepository empresaRepository;

    @InjectMocks
    private RemoverEmpresaRepositoryAdapter removerEmpresaRepositoryAdapter;

    @Test
    void deveRemoverEmpresaComSucesso() {

        final Integer idEmpresa = 1;
        final EmpresaEntity empresaEntity = new EmpresaEntity();

        when(empresaRepository.findById(idEmpresa)).thenReturn(Optional.of(empresaEntity));

        assertDoesNotThrow(() -> removerEmpresaRepositoryAdapter.remover(idEmpresa));

        verify(empresaRepository).findById(idEmpresa);
        verify(empresaRepository).deleteById(idEmpresa);
    }

    @Test
    void deveLancarExcecaoQuandoEmpresaNaoForEncontrada() {

        final Integer idEmpresa = 1;

        when(empresaRepository.findById(idEmpresa)).thenReturn(Optional.empty());

        assertThrows(EmpresaNaoEncontradaException.class,
                () -> removerEmpresaRepositoryAdapter.remover(idEmpresa));

        verify(empresaRepository).findById(idEmpresa);
        verify(empresaRepository, never()).deleteById(idEmpresa);
    }
}