package br.com.olharpedagogicoia.adapters.out.funcionario;

import br.com.olharpedagogicoia.adapters.out.funcionario.entity.FuncionarioEntity;
import br.com.olharpedagogicoia.adapters.out.funcionario.mapper.FuncionarioMapper;
import br.com.olharpedagogicoia.adapters.out.funcionario.repository.FuncionarioRepository;
import br.com.olharpedagogicoia.application.dto.FuncionarioDTO;
import br.com.olharpedagogicoia.application.exceptions.FuncionarioNaoEncontradoException;
import br.com.olharpedagogicoia.application.stub.FuncionarioStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ConsultarFuncionarioRepositoryAdapterTest {

    @Mock
    private FuncionarioRepository funcionarioRepository;

    @Mock
    private FuncionarioMapper funcionarioMapper;

    @InjectMocks
    private ConsultarFuncionarioRepositoryAdapter consultarFuncionarioRepositoryAdapter;

    @Test
    void deveConsultarFuncionarioComSucesso() throws FuncionarioNaoEncontradoException {

        final Integer idFuncionario = 1;
        final FuncionarioDTO funcionarioDTO = FuncionarioStub.getFuncionarioCompleta();
        final FuncionarioEntity funcionarioEntity = new FuncionarioEntity();

        when(funcionarioRepository.findById(idFuncionario)).thenReturn(Optional.of(funcionarioEntity));
        when(funcionarioMapper.deFuncionarioEntityParaFuncionarioDTO(funcionarioEntity)).thenReturn(funcionarioDTO);

        final FuncionarioDTO resposta = consultarFuncionarioRepositoryAdapter.consultar(idFuncionario);

        assertNotNull(resposta);
        assertEquals(funcionarioDTO, resposta);

        verify(funcionarioRepository).findById(idFuncionario);
        verify(funcionarioMapper).deFuncionarioEntityParaFuncionarioDTO(funcionarioEntity);
    }

    @Test
    void deveLancarExcecaoQuandoFuncionarioNaoForEncontrado() {

        final Integer idFuncionario = 1;

        when(funcionarioRepository.findById(idFuncionario)).thenReturn(Optional.empty());

        assertThrows(FuncionarioNaoEncontradoException.class,
                () -> consultarFuncionarioRepositoryAdapter.consultar(idFuncionario));

        verify(funcionarioRepository).findById(idFuncionario);
        verifyNoInteractions(funcionarioMapper);
    }
}