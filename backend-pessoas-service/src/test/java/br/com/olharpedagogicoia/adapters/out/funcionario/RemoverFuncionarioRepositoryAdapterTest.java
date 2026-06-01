package br.com.olharpedagogicoia.adapters.out.funcionario;

import br.com.olharpedagogicoia.adapters.out.funcionario.entity.FuncionarioEntity;
import br.com.olharpedagogicoia.adapters.out.funcionario.repository.FuncionarioRepository;
import br.com.olharpedagogicoia.application.exceptions.FuncionarioNaoEncontradoException;
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
public class RemoverFuncionarioRepositoryAdapterTest {

    @Mock
    private FuncionarioRepository funcionarioRepository;

    @InjectMocks
    private RemoverFuncionarioRepositoryAdapter removerFuncionarioRepositoryAdapter;

    @Test
    void deveRemoverFuncionarioComSucesso() {

        final Integer idFuncionario = 1;
        final FuncionarioEntity funcionarioEntity = new FuncionarioEntity();

        when(funcionarioRepository.findById(idFuncionario)).thenReturn(Optional.of(funcionarioEntity));

        assertDoesNotThrow(() -> removerFuncionarioRepositoryAdapter.remover(idFuncionario));

        verify(funcionarioRepository).findById(idFuncionario);
        verify(funcionarioRepository).deleteById(idFuncionario);
    }

    @Test
    void deveLancarExcecaoQuandoFuncionarioNaoForEncontrado() {

        final Integer idFuncionario = 1;

        when(funcionarioRepository.findById(idFuncionario)).thenReturn(Optional.empty());

        assertThrows(FuncionarioNaoEncontradoException.class,
                () -> removerFuncionarioRepositoryAdapter.remover(idFuncionario));

        verify(funcionarioRepository).findById(idFuncionario);
        verify(funcionarioRepository, never()).deleteById(idFuncionario);
    }
}