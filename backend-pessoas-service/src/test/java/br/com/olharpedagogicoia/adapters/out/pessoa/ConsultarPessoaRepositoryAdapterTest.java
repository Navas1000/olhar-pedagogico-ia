package br.com.olharpedagogicoia.adapters.out.pessoa;

import br.com.olharpedagogicoia.adapters.out.pessoa.entity.PessoaEntity;
import br.com.olharpedagogicoia.adapters.out.pessoa.mapper.PessoaMapper;
import br.com.olharpedagogicoia.adapters.out.pessoa.repository.PessoaRepository;
import br.com.olharpedagogicoia.application.dto.PessoaDTO;
import br.com.olharpedagogicoia.application.exceptions.PessoaNaoEncontradaException;
import br.com.olharpedagogicoia.application.stub.PessoaStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ConsultarPessoaRepositoryAdapterTest {

    @Mock
    private PessoaRepository pessoaRepository;

    @Mock
    private PessoaMapper pessoaMapper;

    @InjectMocks
    private ConsultarPessoaRepositoryAdapter consultarPessoaRepositoryAdapter;

    @Test
    void deveConsultarPessoaComSucesso() throws PessoaNaoEncontradaException {

        final Integer idPessoa = 1;
        final PessoaDTO pessoaDTO = PessoaStub.getPessoaCompleta();
        final PessoaEntity pessoaEntity = new PessoaEntity();

        when(pessoaRepository.findById(idPessoa)).thenReturn(Optional.of(pessoaEntity));
        when(pessoaMapper.dePessoaEntityParaPessoaDTO(pessoaEntity)).thenReturn(pessoaDTO);

        final PessoaDTO resposta = consultarPessoaRepositoryAdapter.consultar(idPessoa);

        assertNotNull(resposta);
        assertEquals(pessoaDTO, resposta);

        verify(pessoaRepository).findById(idPessoa);
        verify(pessoaMapper).dePessoaEntityParaPessoaDTO(pessoaEntity);
    }

    @Test
    void deveLancarExcecaoQuandoPessoaNaoForEncontrada() {

        final Integer idPessoa = 1;

        when(pessoaRepository.findById(idPessoa)).thenReturn(Optional.empty());

        assertThrows(PessoaNaoEncontradaException.class,
                () -> consultarPessoaRepositoryAdapter.consultar(idPessoa));

        verify(pessoaRepository).findById(idPessoa);
        verifyNoInteractions(pessoaMapper);
    }
}