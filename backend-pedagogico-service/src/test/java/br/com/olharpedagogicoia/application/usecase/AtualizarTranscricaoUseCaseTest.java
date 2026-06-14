package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.TranscricaoDTO;
import br.com.olharpedagogicoia.application.exceptions.IdTranscricaoObrigatorioException;
import br.com.olharpedagogicoia.application.exceptions.TranscricaoNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.out.AtualizarTranscricaoPortOut;
import br.com.olharpedagogicoia.application.port.out.ConsultarTranscricaoPortOut;
import br.com.olharpedagogicoia.application.stub.TranscricaoStub;
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
public class AtualizarTranscricaoUseCaseTest {

    @Mock
    private ConsultarTranscricaoPortOut consultarTranscricaoPortOut;

    @Spy
    private AtualizarTranscricaoPortOut atualizarTranscricaoPortOut;

    @InjectMocks
    private AtualizarTranscricaoUseCase atualizarTranscricaoUseCase;

    @Test
    void deveAtualizarTranscricaoDto()
            throws TranscricaoNaoEncontradaException, IdTranscricaoObrigatorioException {

        final TranscricaoDTO transcricaoConsultada =
                TranscricaoStub.getTranscricaoCompleta();

        when(consultarTranscricaoPortOut.consultar(anyInt()))
                .thenReturn(transcricaoConsultada);

        final TranscricaoDTO transcricaoAtualizada =
                TranscricaoStub.getTranscricaoAlterada();

        when(atualizarTranscricaoPortOut.atualizar(any(TranscricaoDTO.class)))
                .thenReturn(transcricaoAtualizada);

        final TranscricaoDTO transcricaoASerAtualizada =
                TranscricaoStub.getTranscricaoCompleta();

        final TranscricaoDTO resultadoDaAtualizacao =
                atualizarTranscricaoUseCase.atualizar(transcricaoASerAtualizada);

        final ArgumentCaptor<TranscricaoDTO> capturador =
                ArgumentCaptor.forClass(TranscricaoDTO.class);

        verify(atualizarTranscricaoPortOut).atualizar(capturador.capture());

        final TranscricaoDTO transcricaoRecebidaNoAtualizar =
                capturador.getValue();

        assertEquals(
                transcricaoConsultada.getDataCriacao(),
                transcricaoRecebidaNoAtualizar.getDataCriacao()
        );

        verify(consultarTranscricaoPortOut).consultar(anyInt());
        verify(atualizarTranscricaoPortOut).atualizar(any(TranscricaoDTO.class));

        assertNotNull(resultadoDaAtualizacao);
    }

    @Test
    void deveLancarAExcecaoIdTranscricaoObrigatorioQuandoIdTranscricaoForNulo() {

        final TranscricaoDTO transcricaoDTO = new TranscricaoDTO();

        assertThrows(
                IdTranscricaoObrigatorioException.class,
                () -> atualizarTranscricaoUseCase.atualizar(transcricaoDTO)
        );
    }

    @Test
    void deveLancarAExcecaoTranscricaoNaoEncontradaQuandoTranscricaoNaoExistirNaBase()
            throws TranscricaoNaoEncontradaException {

        when(consultarTranscricaoPortOut.consultar(anyInt()))
                .thenThrow(TranscricaoNaoEncontradaException.class);

        final TranscricaoDTO transcricaoDTO =
                TranscricaoStub.getTranscricaoCompleta();

        assertThrows(
                TranscricaoNaoEncontradaException.class,
                () -> atualizarTranscricaoUseCase.atualizar(transcricaoDTO)
        );
    }
}