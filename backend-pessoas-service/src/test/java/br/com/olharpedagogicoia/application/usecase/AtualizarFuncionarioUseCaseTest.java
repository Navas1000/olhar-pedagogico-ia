package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.FuncionarioDTO;
import br.com.olharpedagogicoia.application.exceptions.FuncionarioNaoEncontradoException;
import br.com.olharpedagogicoia.application.exceptions.IdFuncionarioObrigatorioException;
import br.com.olharpedagogicoia.application.port.out.AtualizarFuncionarioPortOut;
import br.com.olharpedagogicoia.application.port.out.ConsultarFuncionarioPortOut;
import br.com.olharpedagogicoia.application.stub.FuncionarioStub;
import br.com.olharpedagogicoia.config.Salt;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AtualizarFuncionarioUseCaseTest {

    @Mock
    private ConsultarFuncionarioPortOut consultarFuncionarioPortOut;

    @Spy
    private AtualizarFuncionarioPortOut atualizarFuncionarioPortOut;

    @Mock
    private Salt salt;

    @InjectMocks
    private AtualizarFuncionarioUseCase atualizarFuncionarioUseCase;

// TODO Corrigir Teste
//    @Test
//    void deveAtualizarFuncionarioDto() throws FuncionarioNaoEncontradoException, IdFuncionarioObrigatorioException {
//
//        when(salt.getSalt()).thenReturn("abc123");
//
//        final FuncionarioDTO funcionarioConsultado = FuncionarioStub.getFuncionarioCompleta();
//        when(consultarFuncionarioPortOut.consultar(anyInt())).thenReturn(funcionarioConsultado);
//
//        final FuncionarioDTO funcionarioAtualizado = FuncionarioStub.getFuncionarioAlterada();
//        when(atualizarFuncionarioPortOut.atualizar(any(FuncionarioDTO.class))).thenReturn(funcionarioAtualizado);
//
//        final FuncionarioDTO funcionarioASerAtualizado = FuncionarioStub.getFuncionarioCompleta();
//
//        final FuncionarioDTO resultadoDaAtualizacao =
//                atualizarFuncionarioUseCase.atualizar(funcionarioASerAtualizado);
//
//        final ArgumentCaptor<FuncionarioDTO> capturador =
//                ArgumentCaptor.forClass(FuncionarioDTO.class);
//
//        verify(atualizarFuncionarioPortOut).atualizar(capturador.capture());
//
//        final FuncionarioDTO funcionarioRecebidoNoAtualizar = capturador.getValue();
//
//        assertEquals(
//                funcionarioConsultado.getDataCriacao(),
//                funcionarioRecebidoNoAtualizar.getDataCriacao()
//        );
//
//        assertNotEquals(
//                funcionarioConsultado.getDataModificacao(),
//                funcionarioRecebidoNoAtualizar.getDataModificacao()
//        );
//
//        assertNotNull(funcionarioRecebidoNoAtualizar.getSenha());
//        assertTrue(funcionarioRecebidoNoAtualizar.getSenha().length() <= 20);
//
//        verify(consultarFuncionarioPortOut).consultar(anyInt());
//        verify(atualizarFuncionarioPortOut).atualizar(any(FuncionarioDTO.class));
//
//        assertNotNull(resultadoDaAtualizacao);
//        assertNull(resultadoDaAtualizacao.getSenha());
//    }

// TODO Corrigir Teste
//    @Test
//    void deveLancarAExcecaoQuandoSenhaForNula() {
//
//        final FuncionarioDTO funcionarioDTO = FuncionarioStub.getFuncionarioCompleta();
//        funcionarioDTO.setSenha(null);
//
//        assertThrows(
//                IllegalArgumentException.class,
//                () -> atualizarFuncionarioUseCase.atualizar(funcionarioDTO)
//        );
//    }

// TODO Corrigir Teste
//    @Test
//    void deveLancarAExcecaoQuandoSenhaForVazia() {
//
//        final FuncionarioDTO funcionarioDTO = FuncionarioStub.getFuncionarioCompleta();
//        funcionarioDTO.setSenha("");
//
//        assertThrows(
//                IllegalArgumentException.class,
//                () -> atualizarFuncionarioUseCase.atualizar(funcionarioDTO)
//        );
//    }

//    TODO Corrigir Teste
//    @Test
//    void deveLancarAExcecaoIdFuncionarioObrigatorioQuandoIdFuncionarioForNulo() {
//
//        final FuncionarioDTO funcionario = FuncionarioStub.getFuncionarioCompleta();
//        funcionario.setIdFuncionario(null);
//
//        assertThrows(
//                IdFuncionarioObrigatorioException.class,
//                () -> atualizarFuncionarioUseCase.atualizar(funcionario)
//        );
//    }

//    TODO Corrigir Teste
//    @Test
//    void deveLancarAExcecaoFuncionarioNaoEncontradoQuandoOFuncionarioNaoExistirNaBase()
//            throws FuncionarioNaoEncontradoException {
//
//        when(consultarFuncionarioPortOut.consultar(anyInt()))
//                .thenThrow(FuncionarioNaoEncontradoException.class);
//
//        final FuncionarioDTO funcionario = FuncionarioStub.getFuncionarioCompleta();
//
//        assertThrows(
//                FuncionarioNaoEncontradoException.class,
//                () -> atualizarFuncionarioUseCase.atualizar(funcionario)
//        );
//    }
}