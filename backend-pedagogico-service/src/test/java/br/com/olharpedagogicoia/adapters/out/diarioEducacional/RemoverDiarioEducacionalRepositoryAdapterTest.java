package br.com.olharpedagogicoia.adapters.out.diarioEducacional;

import br.com.olharpedagogicoia.adapters.out.diarioEducacional.entity.DiarioEducacionalEntity;
import br.com.olharpedagogicoia.adapters.out.diarioEducacional.repository.DiarioEducacionalRepository;
import br.com.olharpedagogicoia.application.exceptions.DiarioEducacionalNaoEncontradoException;
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
public class RemoverDiarioEducacionalRepositoryAdapterTest {

    @Mock
    private DiarioEducacionalRepository diarioEducacionalRepository;

    @InjectMocks
    private RemoverDiarioEducacionalRepositoryAdapter removerDiarioEducacionalRepositoryAdapter;

    @Test
    void deveRemoverDiarioEducacionalComSucesso() {

        final Integer idDiario = 1;
        final DiarioEducacionalEntity diarioEducacionalEntity = new DiarioEducacionalEntity();

        when(diarioEducacionalRepository.findById(idDiario))
                .thenReturn(Optional.of(diarioEducacionalEntity));

        assertDoesNotThrow(() ->
                removerDiarioEducacionalRepositoryAdapter.remover(idDiario)
        );

        verify(diarioEducacionalRepository).findById(idDiario);
        verify(diarioEducacionalRepository).deleteById(idDiario);
    }

    @Test
    void deveLancarExcecaoQuandoDiarioEducacionalNaoForEncontrado() {

        final Integer idDiario = 1;

        when(diarioEducacionalRepository.findById(idDiario))
                .thenReturn(Optional.empty());

        assertThrows(
                DiarioEducacionalNaoEncontradoException.class,
                () -> removerDiarioEducacionalRepositoryAdapter.remover(idDiario)
        );

        verify(diarioEducacionalRepository).findById(idDiario);
        verify(diarioEducacionalRepository, never()).deleteById(idDiario);
    }
}