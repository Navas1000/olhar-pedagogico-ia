package br.com.olharpedagogicoia.adapters.out.resumoEducacional;

import br.com.olharpedagogicoia.adapters.out.resumoEducacional.entity.ResumoEducacionalEntity;
import br.com.olharpedagogicoia.adapters.out.resumoEducacional.repository.ResumoEducacionalRepository;
import br.com.olharpedagogicoia.application.exceptions.ResumoEducacionalNaoEncontradoException;
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
public class RemoverResumoEducacionalRepositoryAdapterTest {

    @Mock
    private ResumoEducacionalRepository resumoEducacionalRepository;

    @InjectMocks
    private RemoverResumoEducacionalRepositoryAdapter removerResumoEducacionalRepositoryAdapter;

    @Test
    void deveRemoverResumoEducacionalComSucesso() {

        final Integer idResumo = 1;

        final ResumoEducacionalEntity resumoEducacionalEntity =
                new ResumoEducacionalEntity();

        when(resumoEducacionalRepository.findById(idResumo))
                .thenReturn(Optional.of(resumoEducacionalEntity));

        assertDoesNotThrow(() ->
                removerResumoEducacionalRepositoryAdapter.remover(idResumo)
        );

        verify(resumoEducacionalRepository).findById(idResumo);
        verify(resumoEducacionalRepository).deleteById(idResumo);
    }

    @Test
    void deveLancarExcecaoQuandoResumoEducacionalNaoForEncontrado() {

        final Integer idResumo = 1;

        when(resumoEducacionalRepository.findById(idResumo))
                .thenReturn(Optional.empty());

        assertThrows(
                ResumoEducacionalNaoEncontradoException.class,
                () -> removerResumoEducacionalRepositoryAdapter.remover(idResumo)
        );

        verify(resumoEducacionalRepository).findById(idResumo);
        verify(resumoEducacionalRepository, never()).deleteById(idResumo);
    }
}