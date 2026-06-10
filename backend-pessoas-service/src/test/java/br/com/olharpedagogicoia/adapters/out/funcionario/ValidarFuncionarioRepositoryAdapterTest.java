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
public class ValidarFuncionarioRepositoryAdapterTest {

    @Mock
    private FuncionarioRepository funcionarioRepository;

    @Mock
    private FuncionarioMapper funcionarioMapper;

    @InjectMocks
    private ValidarFuncionarioRepositoryAdapter validarFuncionarioRepositoryAdapter;

    @Test
    void deveValidarFuncionarioComSucesso() throws FuncionarioNaoEncontradoException {

        final String nomeUsuario = "luana";
        final String senha = "senhaCriptografada";

        final FuncionarioEntity funcionarioEntity = new FuncionarioEntity();
        final FuncionarioDTO funcionarioDTO = FuncionarioStub.getFuncionarioCompleta();

        when(funcionarioRepository.findByNomeUsuarioAndSenha(nomeUsuario, senha))
                .thenReturn(Optional.of(funcionarioEntity));

        when(funcionarioMapper.deFuncionarioEntityParaFuncionarioDTO(funcionarioEntity))
                .thenReturn(funcionarioDTO);

        final FuncionarioDTO resposta =
                validarFuncionarioRepositoryAdapter.validar(nomeUsuario, senha);

        assertNotNull(resposta);
        assertEquals(funcionarioDTO, resposta);

        verify(funcionarioRepository).findByNomeUsuarioAndSenha(nomeUsuario, senha);
        verify(funcionarioMapper).deFuncionarioEntityParaFuncionarioDTO(funcionarioEntity);
    }

    @Test
    void deveLancarExcecaoQuandoFuncionarioNaoForValidado() {

        final String nomeUsuario = "luana";
        final String senha = "senhaErrada";

        when(funcionarioRepository.findByNomeUsuarioAndSenha(nomeUsuario, senha))
                .thenReturn(Optional.empty());

        assertThrows(
                FuncionarioNaoEncontradoException.class,
                () -> validarFuncionarioRepositoryAdapter.validar(nomeUsuario, senha)
        );

        verify(funcionarioRepository).findByNomeUsuarioAndSenha(nomeUsuario, senha);
        verifyNoInteractions(funcionarioMapper);
    }
}