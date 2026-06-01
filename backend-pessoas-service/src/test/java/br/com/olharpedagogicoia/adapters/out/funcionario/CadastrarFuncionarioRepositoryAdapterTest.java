package br.com.olharpedagogicoia.adapters.out.funcionario;

import br.com.olharpedagogicoia.adapters.out.funcionario.entity.FuncionarioEntity;
import br.com.olharpedagogicoia.adapters.out.funcionario.mapper.FuncionarioMapper;
import br.com.olharpedagogicoia.adapters.out.funcionario.repository.FuncionarioRepository;
import br.com.olharpedagogicoia.application.dto.FuncionarioDTO;
import br.com.olharpedagogicoia.application.stub.FuncionarioStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CadastrarFuncionarioRepositoryAdapterTest {

    @Mock
    private FuncionarioRepository funcionarioRepository;

    @Mock
    private FuncionarioMapper funcionarioMapper;

    @InjectMocks
    private CadastrarFuncionarioRepositoryAdapter cadastrarFuncionarioRepositoryAdapter;

    @Test
    void deveCadastrarFuncionarioComSucesso() {

        final FuncionarioDTO funcionarioDTO = FuncionarioStub.getFuncionarioCompleta();
        final FuncionarioEntity funcionarioEntity = new FuncionarioEntity();

        when(funcionarioMapper.deFuncionarioDTOParaFuncionarioEntity(funcionarioDTO)).thenReturn(funcionarioEntity);
        when(funcionarioRepository.save(funcionarioEntity)).thenReturn(funcionarioEntity);
        when(funcionarioMapper.deFuncionarioEntityParaFuncionarioDTO(funcionarioEntity)).thenReturn(funcionarioDTO);

        final FuncionarioDTO resposta = cadastrarFuncionarioRepositoryAdapter.cadastrar(funcionarioDTO);

        assertNotNull(resposta);
        assertEquals(funcionarioDTO, resposta);

        verify(funcionarioMapper).deFuncionarioDTOParaFuncionarioEntity(funcionarioDTO);
        verify(funcionarioRepository).save(funcionarioEntity);
        verify(funcionarioMapper).deFuncionarioEntityParaFuncionarioDTO(funcionarioEntity);
    }
}