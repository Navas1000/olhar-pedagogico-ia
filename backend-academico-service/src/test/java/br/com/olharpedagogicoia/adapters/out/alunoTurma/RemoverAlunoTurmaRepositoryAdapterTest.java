package br.com.olharpedagogicoia.adapters.out.alunoTurma;

import br.com.olharpedagogicoia.adapters.out.alunoTurma.entity.AlunoTurmaEntity;
import br.com.olharpedagogicoia.adapters.out.alunoTurma.repository.AlunoTurmaRepository;
import br.com.olharpedagogicoia.application.exceptions.AlunoTurmaNaoEncontradaException;
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
public class RemoverAlunoTurmaRepositoryAdapterTest {

    @Mock
    private AlunoTurmaRepository alunoTurmaRepository;

    @InjectMocks
    private RemoverAlunoTurmaRepositoryAdapter removerAlunoTurmaRepositoryAdapter;

    @Test
    void deveRemoverAlunoTurmaComSucesso() {

        final Integer idMatricula = 1;
        final AlunoTurmaEntity alunoTurmaEntity = new AlunoTurmaEntity();

        when(alunoTurmaRepository.findById(idMatricula)).thenReturn(Optional.of(alunoTurmaEntity));

        assertDoesNotThrow(() -> removerAlunoTurmaRepositoryAdapter.remover(idMatricula));

        verify(alunoTurmaRepository).findById(idMatricula);
        verify(alunoTurmaRepository).deleteById(idMatricula);
    }

    @Test
    void deveLancarExcecaoQuandoAlunoTurmaNaoForEncontrada() {

        final Integer idMatricula = 1;

        when(alunoTurmaRepository.findById(idMatricula)).thenReturn(Optional.empty());

        assertThrows(
                AlunoTurmaNaoEncontradaException.class,
                () -> removerAlunoTurmaRepositoryAdapter.remover(idMatricula)
        );

        verify(alunoTurmaRepository).findById(idMatricula);
        verify(alunoTurmaRepository, never()).deleteById(idMatricula);
    }
}