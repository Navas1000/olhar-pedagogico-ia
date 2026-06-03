package br.com.olharpedagogicoia.adapters.out.aula;

import br.com.olharpedagogicoia.adapters.out.aula.entity.AulaEntity;
import br.com.olharpedagogicoia.adapters.out.aula.repository.AulaRepository;
import br.com.olharpedagogicoia.application.exceptions.AulaNaoEncontradaException;
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
public class RemoverAulaRepositoryAdapterTest {

    @Mock
    private AulaRepository aulaRepository;

    @InjectMocks
    private RemoverAulaRepositoryAdapter removerAulaRepositoryAdapter;

    @Test
    void deveRemoverAulaComSucesso() {

        final Integer idAula = 1;
        final AulaEntity aulaEntity = new AulaEntity();

        when(aulaRepository.findById(idAula)).thenReturn(Optional.of(aulaEntity));

        assertDoesNotThrow(() -> removerAulaRepositoryAdapter.remover(idAula));

        verify(aulaRepository).findById(idAula);
        verify(aulaRepository).deleteById(idAula);
    }

    @Test
    void deveLancarExcecaoQuandoAulaNaoForEncontrada() {

        final Integer idAula = 1;

        when(aulaRepository.findById(idAula)).thenReturn(Optional.empty());

        assertThrows(
                AulaNaoEncontradaException.class,
                () -> removerAulaRepositoryAdapter.remover(idAula)
        );

        verify(aulaRepository).findById(idAula);
        verify(aulaRepository, never()).deleteById(idAula);
    }
}