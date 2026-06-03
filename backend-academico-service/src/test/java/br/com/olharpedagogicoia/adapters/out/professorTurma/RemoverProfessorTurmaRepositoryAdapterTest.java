package br.com.olharpedagogicoia.adapters.out.professorTurma;

import br.com.olharpedagogicoia.adapters.out.professorTurma.entity.ProfessorTurmaEntity;
import br.com.olharpedagogicoia.adapters.out.professorTurma.repository.ProfessorTurmaRepository;
import br.com.olharpedagogicoia.application.exceptions.ProfessorTurmaNaoEncontradaException;
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
public class RemoverProfessorTurmaRepositoryAdapterTest {

    @Mock
    private ProfessorTurmaRepository professorTurmaRepository;

    @InjectMocks
    private RemoverProfessorTurmaRepositoryAdapter removerProfessorTurmaRepositoryAdapter;

    @Test
    void deveRemoverProfessorTurmaComSucesso() {

        final Integer idAlocacao = 1;
        final ProfessorTurmaEntity professorTurmaEntity = new ProfessorTurmaEntity();

        when(professorTurmaRepository.findById(idAlocacao)).thenReturn(Optional.of(professorTurmaEntity));

        assertDoesNotThrow(() -> removerProfessorTurmaRepositoryAdapter.remover(idAlocacao));

        verify(professorTurmaRepository).findById(idAlocacao);
        verify(professorTurmaRepository).deleteById(idAlocacao);
    }

    @Test
    void deveLancarExcecaoQuandoProfessorTurmaNaoForEncontrado() {

        final Integer idAlocacao = 1;

        when(professorTurmaRepository.findById(idAlocacao)).thenReturn(Optional.empty());

        assertThrows(
                ProfessorTurmaNaoEncontradaException.class,
                () -> removerProfessorTurmaRepositoryAdapter.remover(idAlocacao)
        );

        verify(professorTurmaRepository).findById(idAlocacao);
        verify(professorTurmaRepository, never()).deleteById(idAlocacao);
    }
}