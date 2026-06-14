package br.com.olharpedagogicoia.adapters.out.transcricao;

import br.com.olharpedagogicoia.adapters.out.transcricao.entity.TranscricaoEntity;
import br.com.olharpedagogicoia.adapters.out.transcricao.repository.TranscricaoRepository;
import br.com.olharpedagogicoia.application.exceptions.TranscricaoNaoEncontradaException;
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
public class RemoverTranscricaoRepositoryAdapterTest {

    @Mock
    private TranscricaoRepository transcricaoRepository;

    @InjectMocks
    private RemoverTranscricaoRepositoryAdapter removerTranscricaoRepositoryAdapter;

    @Test
    void deveRemoverTranscricaoComSucesso() {

        final Integer idTranscricao = 1;
        final TranscricaoEntity transcricaoEntity = new TranscricaoEntity();

        when(transcricaoRepository.findById(idTranscricao))
                .thenReturn(Optional.of(transcricaoEntity));

        assertDoesNotThrow(() ->
                removerTranscricaoRepositoryAdapter.remover(idTranscricao)
        );

        verify(transcricaoRepository).findById(idTranscricao);
        verify(transcricaoRepository).deleteById(idTranscricao);
    }

    @Test
    void deveLancarExcecaoQuandoTranscricaoNaoForEncontrada() {

        final Integer idTranscricao = 1;

        when(transcricaoRepository.findById(idTranscricao))
                .thenReturn(Optional.empty());

        assertThrows(
                TranscricaoNaoEncontradaException.class,
                () -> removerTranscricaoRepositoryAdapter.remover(idTranscricao)
        );

        verify(transcricaoRepository).findById(idTranscricao);
        verify(transcricaoRepository, never()).deleteById(idTranscricao);
    }
}