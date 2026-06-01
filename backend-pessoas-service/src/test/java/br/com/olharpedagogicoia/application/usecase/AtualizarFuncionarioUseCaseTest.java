package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.FuncionarioDTO;
import br.com.olharpedagogicoia.application.exceptions.FuncionarioNaoEncontradoException;
import br.com.olharpedagogicoia.application.exceptions.IdFuncionarioObrigatorioException;
import br.com.olharpedagogicoia.application.port.out.AtualizarFuncionarioPortOut;
import br.com.olharpedagogicoia.application.port.out.ConsultarFuncionarioPortOut;
import br.com.olharpedagogicoia.application.stub.FuncionarioStub;
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

    @InjectMocks
    private AtualizarFuncionarioUseCase atualizarFuncionarioUseCase;

    @Test
    void deveAtualizarFuncionarioDto() throws FuncionarioNaoEncontradoException, IdFuncionarioObrigatorioException {

        final FuncionarioDTO funcionarioConsultado = FuncionarioStub.getFuncionarioCompleta();
        when(consultarFuncionarioPortOut.consultar(anyInt())).thenReturn(funcionarioConsultado);

        final FuncionarioDTO funcionarioAtualizado = FuncionarioStub.getFuncionarioAlterada();
        when(atualizarFuncionarioPortOut.atualizar(any(FuncionarioDTO.class))).thenReturn(funcionarioAtualizado);

        final FuncionarioDTO funcionarioASerAtualizado = FuncionarioStub.getFuncionarioCompleta();

        final FuncionarioDTO resultadoDaAtualizacao =
                atualizarFuncionarioUseCase.atualizar(funcionarioASerAtualizado);

        final ArgumentCaptor<FuncionarioDTO> capturador =
                ArgumentCaptor.forClass(FuncionarioDTO.class);

        verify(atualizarFuncionarioPortOut).atualizar(capturador.capture());

        final FuncionarioDTO funcionarioRecebidoNoAtualizar = capturador.getValue();

        assertEquals(
                funcionarioConsultado.getDataCriacao(),
                funcionarioRecebidoNoAtualizar.getDataCriacao()
        );

        assertNotEquals(
                funcionarioConsultado.getDataModificacao(),
                funcionarioRecebidoNoAtualizar.getDataModificacao()
        );

        verify(consultarFuncionarioPortOut).consultar(anyInt());
        verify(atualizarFuncionarioPortOut).atualizar(any(FuncionarioDTO.class));

        assertNotNull(resultadoDaAtualizacao);
    }

    @Test
    void deveLancarAExcecaoIdFuncionarioObrigatorioQuandoIdFuncionarioForNulo() {

        final FuncionarioDTO funcionario = new FuncionarioDTO();

        assertThrows(
                IdFuncionarioObrigatorioException.class,
                () -> atualizarFuncionarioUseCase.atualizar(funcionario)
        );
    }

    @Test
    void deveLancarAExcecaoFuncionarioNaoEncontradoQuandoOFuncionarioNaoExistirNaBase()
            throws FuncionarioNaoEncontradoException {

        when(consultarFuncionarioPortOut.consultar(anyInt()))
                .thenThrow(FuncionarioNaoEncontradoException.class);

        final FuncionarioDTO funcionario = FuncionarioStub.getFuncionarioCompleta();

        assertThrows(
                FuncionarioNaoEncontradoException.class,
                () -> atualizarFuncionarioUseCase.atualizar(funcionario)
        );
    }
}