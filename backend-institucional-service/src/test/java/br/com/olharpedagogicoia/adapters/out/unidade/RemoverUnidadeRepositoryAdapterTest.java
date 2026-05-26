package br.com.olharpedagogicoia.adapters.out.unidade;

import br.com.olharpedagogicoia.adapters.out.unidade.entity.UnidadeEntity;
import br.com.olharpedagogicoia.adapters.out.unidade.repository.UnidadeRepository;
import br.com.olharpedagogicoia.application.exceptions.UnidadeNaoEncontradaException;
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
public class RemoverUnidadeRepositoryAdapterTest {

    @Mock
    private UnidadeRepository unidadeRepository;

    @InjectMocks
    private RemoverUnidadeRepositoryAdapter removerUnidadeRepositoryAdapter;

    @Test
    void deveRemoverUnidadeComSucesso() {

        final Integer idUnidade = 1;
        final UnidadeEntity unidadeEntity = new UnidadeEntity();

        when(unidadeRepository.findById(idUnidade)).thenReturn(Optional.of(unidadeEntity));

        assertDoesNotThrow(() -> removerUnidadeRepositoryAdapter.remover(idUnidade));

        verify(unidadeRepository).findById(idUnidade);
        verify(unidadeRepository).deleteById(idUnidade);
    }

    @Test
    void deveLancarExcecaoQuandoUnidadeNaoForEncontrada() {

        final Integer idUnidade = 1;

        when(unidadeRepository.findById(idUnidade)).thenReturn(Optional.empty());

        assertThrows(UnidadeNaoEncontradaException.class,
                () -> removerUnidadeRepositoryAdapter.remover(idUnidade));

        verify(unidadeRepository).findById(idUnidade);
        verify(unidadeRepository, never()).deleteById(idUnidade);
    }
}