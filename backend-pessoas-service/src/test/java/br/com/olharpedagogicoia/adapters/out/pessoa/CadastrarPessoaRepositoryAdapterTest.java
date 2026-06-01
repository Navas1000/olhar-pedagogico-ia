package br.com.olharpedagogicoia.adapters.out.pessoa;

import br.com.olharpedagogicoia.adapters.out.pessoa.entity.PessoaEntity;
import br.com.olharpedagogicoia.adapters.out.pessoa.mapper.PessoaMapper;
import br.com.olharpedagogicoia.adapters.out.pessoa.repository.PessoaRepository;
import br.com.olharpedagogicoia.application.dto.PessoaDTO;
import br.com.olharpedagogicoia.application.stub.PessoaStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CadastrarPessoaRepositoryAdapterTest {

    @Mock
    private PessoaRepository pessoaRepository;

    @Mock
    private PessoaMapper pessoaMapper;

    @InjectMocks
    private CadastrarPessoaRepositoryAdapter cadastrarPessoaRepositoryAdapter;

    @Test
    void deveCadastrarPessoaComSucesso() {

        final PessoaDTO pessoaDTO = PessoaStub.getPessoaCompleta();
        final PessoaEntity pessoaEntity = new PessoaEntity();

        when(pessoaMapper.dePessoaDTOParaPessoaEntity(pessoaDTO)).thenReturn(pessoaEntity);
        when(pessoaRepository.save(pessoaEntity)).thenReturn(pessoaEntity);
        when(pessoaMapper.dePessoaEntityParaPessoaDTO(pessoaEntity)).thenReturn(pessoaDTO);

        final PessoaDTO resposta = cadastrarPessoaRepositoryAdapter.cadastrar(pessoaDTO);

        assertNotNull(resposta);
        assertEquals(pessoaDTO, resposta);

        verify(pessoaMapper).dePessoaDTOParaPessoaEntity(pessoaDTO);
        verify(pessoaRepository).save(pessoaEntity);
        verify(pessoaMapper).dePessoaEntityParaPessoaDTO(pessoaEntity);
    }
}