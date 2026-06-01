package br.com.olharpedagogicoia.adapters.out.pessoa;

import br.com.olharpedagogicoia.adapters.out.pessoa.entity.PessoaEntity;
import br.com.olharpedagogicoia.adapters.out.pessoa.repository.PessoaRepository;
import br.com.olharpedagogicoia.application.exceptions.PessoaNaoEncontradaException;
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
public class RemoverPessoaRepositoryAdapterTest {

    @Mock
    private PessoaRepository pessoaRepository;

    @InjectMocks
    private RemoverPessoaRepositoryAdapter removerPessoaRepositoryAdapter;

    @Test
    void deveRemoverPessoaComSucesso() {

        final Integer idPessoa = 1;
        final PessoaEntity pessoaEntity = new PessoaEntity();

        when(pessoaRepository.findById(idPessoa)).thenReturn(Optional.of(pessoaEntity));

        assertDoesNotThrow(() -> removerPessoaRepositoryAdapter.remover(idPessoa));

        verify(pessoaRepository).findById(idPessoa);
        verify(pessoaRepository).deleteById(idPessoa);
    }

    @Test
    void deveLancarExcecaoQuandoPessoaNaoForEncontrada() {

        final Integer idPessoa = 1;

        when(pessoaRepository.findById(idPessoa)).thenReturn(Optional.empty());

        assertThrows(PessoaNaoEncontradaException.class,
                () -> removerPessoaRepositoryAdapter.remover(idPessoa));

        verify(pessoaRepository).findById(idPessoa);
        verify(pessoaRepository, never()).deleteById(idPessoa);
    }
}