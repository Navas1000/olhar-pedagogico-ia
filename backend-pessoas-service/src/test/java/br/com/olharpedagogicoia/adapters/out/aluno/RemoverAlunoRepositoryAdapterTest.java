package br.com.olharpedagogicoia.adapters.out.aluno;

import br.com.olharpedagogicoia.adapters.out.aluno.entity.AlunoEntity;
import br.com.olharpedagogicoia.adapters.out.aluno.repository.AlunoRepository;
import br.com.olharpedagogicoia.application.exceptions.AlunoNaoEncontradoException;
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
public class RemoverAlunoRepositoryAdapterTest {

    @Mock
    private AlunoRepository alunoRepository;

    @InjectMocks
    private RemoverAlunoRepositoryAdapter removerAlunoRepositoryAdapter;

    @Test
    void deveRemoverAlunoComSucesso() {

        final Integer idAluno = 1;
        final AlunoEntity alunoEntity = new AlunoEntity();

        when(alunoRepository.findById(idAluno)).thenReturn(Optional.of(alunoEntity));

        assertDoesNotThrow(() -> removerAlunoRepositoryAdapter.remover(idAluno));

        verify(alunoRepository).findById(idAluno);
        verify(alunoRepository).deleteById(idAluno);
    }

    @Test
    void deveLancarExcecaoQuandoAlunoNaoForEncontrado() {

        final Integer idAluno = 1;

        when(alunoRepository.findById(idAluno)).thenReturn(Optional.empty());

        assertThrows(AlunoNaoEncontradoException.class,
                () -> removerAlunoRepositoryAdapter.remover(idAluno));

        verify(alunoRepository).findById(idAluno);
        verify(alunoRepository, never()).deleteById(idAluno);
    }
}