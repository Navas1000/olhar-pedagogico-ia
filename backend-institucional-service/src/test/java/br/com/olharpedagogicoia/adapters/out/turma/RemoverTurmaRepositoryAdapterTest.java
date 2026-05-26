package br.com.olharpedagogicoia.adapters.out.turma;

import br.com.olharpedagogicoia.adapters.out.turma.entity.TurmaEntity;
import br.com.olharpedagogicoia.adapters.out.turma.repository.TurmaRepository;
import br.com.olharpedagogicoia.application.exceptions.TurmaNaoEncontradaException;
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
public class RemoverTurmaRepositoryAdapterTest {

    @Mock
    private TurmaRepository turmaRepository;

    @InjectMocks
    private RemoverTurmaRepositoryAdapter removerTurmaRepositoryAdapter;

    @Test
    void deveRemoverTurmaComSucesso() {

        final Integer idTurma = 1;
        final TurmaEntity turmaEntity = new TurmaEntity();

        when(turmaRepository.findById(idTurma)).thenReturn(Optional.of(turmaEntity));

        assertDoesNotThrow(() -> removerTurmaRepositoryAdapter.remover(idTurma));

        verify(turmaRepository).findById(idTurma);
        verify(turmaRepository).deleteById(idTurma);
    }

    @Test
    void deveLancarExcecaoQuandoTurmaNaoForEncontrada() {

        final Integer idTurma = 1;

        when(turmaRepository.findById(idTurma)).thenReturn(Optional.empty());

        assertThrows(TurmaNaoEncontradaException.class,
                () -> removerTurmaRepositoryAdapter.remover(idTurma));

        verify(turmaRepository).findById(idTurma);
        verify(turmaRepository, never()).deleteById(idTurma);
    }
}