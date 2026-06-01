package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.PapelFuncaoDTO;
import br.com.olharpedagogicoia.application.exceptions.IdPapelFuncaoObrigatorioException;
import br.com.olharpedagogicoia.application.exceptions.PapelFuncaoNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.out.AtualizarPapelFuncaoPortOut;
import br.com.olharpedagogicoia.application.port.out.ConsultarPapelFuncaoPortOut;
import br.com.olharpedagogicoia.application.stub.PapelFuncaoStub;
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
public class AtualizarPapelFuncaoUseCaseTest {

    @Mock
    private ConsultarPapelFuncaoPortOut consultarPapelFuncaoPortOut;

    @Spy
    private AtualizarPapelFuncaoPortOut atualizarPapelFuncaoPortOut;

    @InjectMocks
    private AtualizarPapelFuncaoUseCase atualizarPapelFuncaoUseCase;

    @Test
    void deveAtualizarPapelFuncaoDto()
            throws PapelFuncaoNaoEncontradoException, IdPapelFuncaoObrigatorioException {

        final PapelFuncaoDTO papelFuncaoConsultado = PapelFuncaoStub.getPapelFuncaoCompleta();
        when(consultarPapelFuncaoPortOut.consultar(anyInt())).thenReturn(papelFuncaoConsultado);

        final PapelFuncaoDTO papelFuncaoAtualizado = PapelFuncaoStub.getPapelFuncaoAlterada();
        when(atualizarPapelFuncaoPortOut.atualizar(any(PapelFuncaoDTO.class)))
                .thenReturn(papelFuncaoAtualizado);

        final PapelFuncaoDTO papelFuncaoASerAtualizado =
                PapelFuncaoStub.getPapelFuncaoCompleta();

        final PapelFuncaoDTO resultadoDaAtualizacao =
                atualizarPapelFuncaoUseCase.atualizar(papelFuncaoASerAtualizado);

        final ArgumentCaptor<PapelFuncaoDTO> capturador =
                ArgumentCaptor.forClass(PapelFuncaoDTO.class);

        verify(atualizarPapelFuncaoPortOut).atualizar(capturador.capture());

        final PapelFuncaoDTO papelFuncaoRecebidoNoAtualizar = capturador.getValue();

        assertEquals(
                papelFuncaoConsultado.getDataCriacao(),
                papelFuncaoRecebidoNoAtualizar.getDataCriacao()
        );

        assertNotEquals(
                papelFuncaoConsultado.getDataModificacao(),
                papelFuncaoRecebidoNoAtualizar.getDataModificacao()
        );

        verify(consultarPapelFuncaoPortOut).consultar(anyInt());
        verify(atualizarPapelFuncaoPortOut).atualizar(any(PapelFuncaoDTO.class));

        assertNotNull(resultadoDaAtualizacao);
    }

    @Test
    void deveLancarAExcecaoIdPapelFuncaoObrigatorioQuandoIdPapelForNulo() {

        final PapelFuncaoDTO papelFuncao = new PapelFuncaoDTO();

        assertThrows(
                IdPapelFuncaoObrigatorioException.class,
                () -> atualizarPapelFuncaoUseCase.atualizar(papelFuncao)
        );
    }

    @Test
    void deveLancarAExcecaoPapelFuncaoNaoEncontradoQuandoOPapelFuncaoNaoExistirNaBase()
            throws PapelFuncaoNaoEncontradoException {

        when(consultarPapelFuncaoPortOut.consultar(anyInt()))
                .thenThrow(PapelFuncaoNaoEncontradoException.class);

        final PapelFuncaoDTO papelFuncao = PapelFuncaoStub.getPapelFuncaoCompleta();

        assertThrows(
                PapelFuncaoNaoEncontradoException.class,
                () -> atualizarPapelFuncaoUseCase.atualizar(papelFuncao)
        );
    }
}