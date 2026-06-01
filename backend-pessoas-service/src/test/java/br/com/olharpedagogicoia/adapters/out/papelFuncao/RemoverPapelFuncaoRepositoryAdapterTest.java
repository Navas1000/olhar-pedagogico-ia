package br.com.olharpedagogicoia.adapters.out.papelFuncao;

import br.com.olharpedagogicoia.adapters.out.papelFuncao.entity.PapelFuncaoEntity;
import br.com.olharpedagogicoia.adapters.out.papelFuncao.repository.PapelFuncaoRepository;
import br.com.olharpedagogicoia.application.exceptions.PapelFuncaoNaoEncontradoException;
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
public class RemoverPapelFuncaoRepositoryAdapterTest {

    @Mock
    private PapelFuncaoRepository papelFuncaoRepository;

    @InjectMocks
    private RemoverPapelFuncaoRepositoryAdapter removerPapelFuncaoRepositoryAdapter;

    @Test
    void deveRemoverPapelFuncaoComSucesso() {

        final Integer idPapel = 1;
        final PapelFuncaoEntity papelFuncaoEntity = new PapelFuncaoEntity();

        when(papelFuncaoRepository.findById(idPapel)).thenReturn(Optional.of(papelFuncaoEntity));

        assertDoesNotThrow(() -> removerPapelFuncaoRepositoryAdapter.remover(idPapel));

        verify(papelFuncaoRepository).findById(idPapel);
        verify(papelFuncaoRepository).deleteById(idPapel);
    }

    @Test
    void deveLancarExcecaoQuandoPapelFuncaoNaoForEncontrado() {

        final Integer idPapel = 1;

        when(papelFuncaoRepository.findById(idPapel)).thenReturn(Optional.empty());

        assertThrows(PapelFuncaoNaoEncontradoException.class,
                () -> removerPapelFuncaoRepositoryAdapter.remover(idPapel));

        verify(papelFuncaoRepository).findById(idPapel);
        verify(papelFuncaoRepository, never()).deleteById(idPapel);
    }
}