package br.com.olharpedagogicoia.adapters.out.resumoAudio;

import br.com.olharpedagogicoia.adapters.out.resumoAudio.entity.ResumoAudioEntity;
import br.com.olharpedagogicoia.adapters.out.resumoAudio.repository.ResumoAudioRepository;
import br.com.olharpedagogicoia.application.exceptions.ResumoAudioNaoEncontradoException;
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
public class RemoverResumoAudioRepositoryAdapterTest {

    @Mock
    private ResumoAudioRepository resumoAudioRepository;

    @InjectMocks
    private RemoverResumoAudioRepositoryAdapter removerResumoAudioRepositoryAdapter;

    @Test
    void deveRemoverResumoAudioComSucesso() {

        final Integer idAudio = 1;
        final ResumoAudioEntity resumoAudioEntity = new ResumoAudioEntity();

        when(resumoAudioRepository.findById(idAudio))
                .thenReturn(Optional.of(resumoAudioEntity));

        assertDoesNotThrow(() ->
                removerResumoAudioRepositoryAdapter.remover(idAudio)
        );

        verify(resumoAudioRepository).findById(idAudio);
        verify(resumoAudioRepository).deleteById(idAudio);
    }

    @Test
    void deveLancarExcecaoQuandoResumoAudioNaoForEncontrado() {

        final Integer idAudio = 1;

        when(resumoAudioRepository.findById(idAudio))
                .thenReturn(Optional.empty());

        assertThrows(
                ResumoAudioNaoEncontradoException.class,
                () -> removerResumoAudioRepositoryAdapter.remover(idAudio)
        );

        verify(resumoAudioRepository).findById(idAudio);
        verify(resumoAudioRepository, never()).deleteById(idAudio);
    }
}