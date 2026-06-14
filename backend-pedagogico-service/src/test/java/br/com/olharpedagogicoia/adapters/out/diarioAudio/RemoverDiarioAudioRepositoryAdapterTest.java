package br.com.olharpedagogicoia.adapters.out.diarioAudio;

import br.com.olharpedagogicoia.adapters.out.diarioAudio.entity.DiarioAudioEntity;
import br.com.olharpedagogicoia.adapters.out.diarioAudio.repository.DiarioAudioRepository;
import br.com.olharpedagogicoia.application.exceptions.DiarioAudioNaoEncontradoException;
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
public class RemoverDiarioAudioRepositoryAdapterTest {

    @Mock
    private DiarioAudioRepository diarioAudioRepository;

    @InjectMocks
    private RemoverDiarioAudioRepositoryAdapter removerDiarioAudioRepositoryAdapter;

    @Test
    void deveRemoverDiarioAudioComSucesso() {

        final Integer idAudio = 1;
        final DiarioAudioEntity diarioAudioEntity = new DiarioAudioEntity();

        when(diarioAudioRepository.findById(idAudio))
                .thenReturn(Optional.of(diarioAudioEntity));

        assertDoesNotThrow(() ->
                removerDiarioAudioRepositoryAdapter.remover(idAudio)
        );

        verify(diarioAudioRepository).findById(idAudio);
        verify(diarioAudioRepository).deleteById(idAudio);
    }

    @Test
    void deveLancarExcecaoQuandoDiarioAudioNaoForEncontrado() {

        final Integer idAudio = 1;

        when(diarioAudioRepository.findById(idAudio))
                .thenReturn(Optional.empty());

        assertThrows(
                DiarioAudioNaoEncontradoException.class,
                () -> removerDiarioAudioRepositoryAdapter.remover(idAudio)
        );

        verify(diarioAudioRepository).findById(idAudio);
        verify(diarioAudioRepository, never()).deleteById(idAudio);
    }
}