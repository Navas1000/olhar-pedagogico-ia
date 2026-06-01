package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.PessoaDTO;
import br.com.olharpedagogicoia.application.exceptions.IdPessoaObrigatorioException;
import br.com.olharpedagogicoia.application.exceptions.PessoaNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.out.AtualizarPessoaPortOut;
import br.com.olharpedagogicoia.application.port.out.ConsultarPessoaPortOut;
import br.com.olharpedagogicoia.application.stub.PessoaStub;
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
public class AtualizarPessoaUseCaseTest {

    @Mock
    private ConsultarPessoaPortOut consultarPessoaPortOut;

    @Spy
    private AtualizarPessoaPortOut atualizarPessoaPortOut;

    @InjectMocks
    private AtualizarPessoaUseCase atualizarPessoaUseCase;

    @Test
    void deveAtualizarPessoaDto() throws PessoaNaoEncontradaException, IdPessoaObrigatorioException {

        final PessoaDTO pessoaConsultada = PessoaStub.getPessoaCompleta();
        when(consultarPessoaPortOut.consultar(anyInt())).thenReturn(pessoaConsultada);

        final PessoaDTO pessoaAtualizada = PessoaStub.getPessoaAlterada();
        when(atualizarPessoaPortOut.atualizar(any(PessoaDTO.class))).thenReturn(pessoaAtualizada);

        final PessoaDTO pessoaASerAtualizada = PessoaStub.getPessoaCompleta();

        final PessoaDTO resultadoDaAtualizacao = atualizarPessoaUseCase.atualizar(pessoaASerAtualizada);

        final ArgumentCaptor<PessoaDTO> capturador = ArgumentCaptor.forClass(PessoaDTO.class);
        verify(atualizarPessoaPortOut).atualizar(capturador.capture());

        final PessoaDTO pessoaRecebidaNoAtualizar = capturador.getValue();

        assertEquals(
                pessoaConsultada.getDataCriacao(),
                pessoaRecebidaNoAtualizar.getDataCriacao()
        );

        assertNotEquals(
                pessoaConsultada.getDataModificacao(),
                pessoaRecebidaNoAtualizar.getDataModificacao()
        );

        verify(consultarPessoaPortOut).consultar(anyInt());
        verify(atualizarPessoaPortOut).atualizar(any(PessoaDTO.class));

        assertNotNull(resultadoDaAtualizacao);
    }

    @Test
    void deveLancarAExcecaoIdPessoaObrigatorioQuandoIdPessoaForNulo() {

        final PessoaDTO pessoa = new PessoaDTO();

        assertThrows(
                IdPessoaObrigatorioException.class,
                () -> atualizarPessoaUseCase.atualizar(pessoa)
        );
    }

    @Test
    void deveLancarAExcecaoPessoaNaoEncontradaQuandoAPessoaNaoExistirNaBase()
            throws PessoaNaoEncontradaException {

        when(consultarPessoaPortOut.consultar(anyInt()))
                .thenThrow(PessoaNaoEncontradaException.class);

        final PessoaDTO pessoa = PessoaStub.getPessoaCompleta();

        assertThrows(
                PessoaNaoEncontradaException.class,
                () -> atualizarPessoaUseCase.atualizar(pessoa)
        );
    }
}