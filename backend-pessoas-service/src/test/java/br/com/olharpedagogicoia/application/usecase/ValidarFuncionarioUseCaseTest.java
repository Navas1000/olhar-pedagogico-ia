package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.FuncionarioDTO;
import br.com.olharpedagogicoia.application.exceptions.FuncionarioNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.out.ValidarFuncionarioPortOut;
import br.com.olharpedagogicoia.application.stub.FuncionarioStub;
import br.com.olharpedagogicoia.config.Salt;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ValidarFuncionarioUseCaseTest {

    @Mock
    private ValidarFuncionarioPortOut validarFuncionarioPortOut;

    @Mock
    private Salt salt;

    @InjectMocks
    private ValidarFuncionarioUseCase validarFuncionarioUseCase;

    @Test
    void deveValidarFuncionarioComSucesso() throws FuncionarioNaoEncontradoException {

        when(salt.getSalt()).thenReturn("abc123");

        final FuncionarioDTO funcionarioEntrada = FuncionarioStub.getFuncionarioCompleta();

        final FuncionarioDTO funcionarioValidado = FuncionarioStub.getFuncionarioCompleta();
        when(validarFuncionarioPortOut.validar(anyString(), anyString())).thenReturn(funcionarioValidado);

        final FuncionarioDTO resposta = validarFuncionarioUseCase.validar(funcionarioEntrada);

        final ArgumentCaptor<String> capturadorNomeUsuario = ArgumentCaptor.forClass(String.class);
        final ArgumentCaptor<String> capturadorSenha = ArgumentCaptor.forClass(String.class);

        verify(validarFuncionarioPortOut).validar(
                capturadorNomeUsuario.capture(),
                capturadorSenha.capture()
        );

        assertEquals(funcionarioEntrada.getNomeUsuario(), capturadorNomeUsuario.getValue());
        assertNotNull(capturadorSenha.getValue());
        assertTrue(capturadorSenha.getValue().length() <= 20);

        assertNotNull(resposta);
        assertNull(resposta.getSenha());
    }

    @Test
    void deveLancarExcecaoQuandoNomeUsuarioForNulo() {

        final FuncionarioDTO funcionarioDTO = FuncionarioStub.getFuncionarioCompleta();
        funcionarioDTO.setNomeUsuario(null);

        assertThrows(
                IllegalArgumentException.class,
                () -> validarFuncionarioUseCase.validar(funcionarioDTO)
        );
    }

    @Test
    void deveLancarExcecaoQuandoNomeUsuarioForVazio() {

        final FuncionarioDTO funcionarioDTO = FuncionarioStub.getFuncionarioCompleta();
        funcionarioDTO.setNomeUsuario("");

        assertThrows(
                IllegalArgumentException.class,
                () -> validarFuncionarioUseCase.validar(funcionarioDTO)
        );
    }

    @Test
    void deveLancarExcecaoQuandoSenhaForNula() {

        final FuncionarioDTO funcionarioDTO = FuncionarioStub.getFuncionarioCompleta();
        funcionarioDTO.setSenha(null);

        assertThrows(
                IllegalArgumentException.class,
                () -> validarFuncionarioUseCase.validar(funcionarioDTO)
        );
    }

    @Test
    void deveLancarExcecaoQuandoSenhaForVazia() {

        final FuncionarioDTO funcionarioDTO = FuncionarioStub.getFuncionarioCompleta();
        funcionarioDTO.setSenha("");

        assertThrows(
                IllegalArgumentException.class,
                () -> validarFuncionarioUseCase.validar(funcionarioDTO)
        );
    }

    @Test
    void deveLancarExcecaoQuandoFuncionarioNaoForValidado()
            throws FuncionarioNaoEncontradoException {

        when(salt.getSalt()).thenReturn("abc123");

        when(validarFuncionarioPortOut.validar(anyString(), anyString()))
                .thenThrow(FuncionarioNaoEncontradoException.class);

        final FuncionarioDTO funcionarioDTO = FuncionarioStub.getFuncionarioCompleta();

        assertThrows(
                FuncionarioNaoEncontradoException.class,
                () -> validarFuncionarioUseCase.validar(funcionarioDTO)
        );
    }
}