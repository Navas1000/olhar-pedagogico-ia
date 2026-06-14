package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.ResumoEducacionalDTO;
import br.com.olharpedagogicoia.application.exceptions.IdResumoEducacionalObrigatorioException;
import br.com.olharpedagogicoia.application.exceptions.ResumoEducacionalNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.out.AtualizarResumoEducacionalPortOut;
import br.com.olharpedagogicoia.application.port.out.ConsultarResumoEducacionalPortOut;
import br.com.olharpedagogicoia.application.stub.ResumoEducacionalStub;
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
public class AtualizarResumoEducacionalUseCaseTest {

    @Mock
    private ConsultarResumoEducacionalPortOut consultarResumoEducacionalPortOut;

    @Spy
    private AtualizarResumoEducacionalPortOut atualizarResumoEducacionalPortOut;

    @InjectMocks
    private AtualizarResumoEducacionalUseCase atualizarResumoEducacionalUseCase;

    @Test
    void deveAtualizarResumoEducacionalDto()
            throws ResumoEducacionalNaoEncontradoException, IdResumoEducacionalObrigatorioException {

        final ResumoEducacionalDTO resumoEducacionalConsultado =
                ResumoEducacionalStub.getResumoEducacionalCompleta();

        when(consultarResumoEducacionalPortOut.consultar(anyInt()))
                .thenReturn(resumoEducacionalConsultado);

        final ResumoEducacionalDTO resumoEducacionalAtualizado =
                ResumoEducacionalStub.getResumoEducacionalAlterada();

        when(atualizarResumoEducacionalPortOut.atualizar(any(ResumoEducacionalDTO.class)))
                .thenReturn(resumoEducacionalAtualizado);

        final ResumoEducacionalDTO resumoEducacionalASerAtualizado =
                ResumoEducacionalStub.getResumoEducacionalCompleta();

        final ResumoEducacionalDTO resultadoDaAtualizacao =
                atualizarResumoEducacionalUseCase.atualizar(resumoEducacionalASerAtualizado);

        final ArgumentCaptor<ResumoEducacionalDTO> capturador =
                ArgumentCaptor.forClass(ResumoEducacionalDTO.class);

        verify(atualizarResumoEducacionalPortOut).atualizar(capturador.capture());

        final ResumoEducacionalDTO resumoEducacionalRecebidoNoAtualizar =
                capturador.getValue();

        assertEquals(
                resumoEducacionalConsultado.getDataCriacao(),
                resumoEducacionalRecebidoNoAtualizar.getDataCriacao()
        );

        verify(consultarResumoEducacionalPortOut).consultar(anyInt());
        verify(atualizarResumoEducacionalPortOut).atualizar(any(ResumoEducacionalDTO.class));

        assertNotNull(resultadoDaAtualizacao);
    }

    @Test
    void deveLancarAExcecaoIdResumoEducacionalObrigatorioQuandoIdResumoForNulo() {

        final ResumoEducacionalDTO resumoEducacionalDTO = new ResumoEducacionalDTO();

        assertThrows(
                IdResumoEducacionalObrigatorioException.class,
                () -> atualizarResumoEducacionalUseCase.atualizar(resumoEducacionalDTO)
        );
    }

    @Test
    void deveLancarAExcecaoResumoEducacionalNaoEncontradoQuandoResumoEducacionalNaoExistirNaBase()
            throws ResumoEducacionalNaoEncontradoException {

        when(consultarResumoEducacionalPortOut.consultar(anyInt()))
                .thenThrow(ResumoEducacionalNaoEncontradoException.class);

        final ResumoEducacionalDTO resumoEducacionalDTO =
                ResumoEducacionalStub.getResumoEducacionalCompleta();

        assertThrows(
                ResumoEducacionalNaoEncontradoException.class,
                () -> atualizarResumoEducacionalUseCase.atualizar(resumoEducacionalDTO)
        );
    }
}