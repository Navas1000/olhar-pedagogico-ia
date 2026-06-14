package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.ResumoAudioDTO;
import br.com.olharpedagogicoia.application.exceptions.IdResumoAudioObrigatorioException;
import br.com.olharpedagogicoia.application.exceptions.ResumoAudioNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.out.AtualizarResumoAudioPortOut;
import br.com.olharpedagogicoia.application.port.out.ConsultarResumoAudioPortOut;
import br.com.olharpedagogicoia.application.stub.ResumoAudioStub;
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
public class AtualizarResumoAudioUseCaseTest {

    @Mock
    private ConsultarResumoAudioPortOut consultarResumoAudioPortOut;

    @Spy
    private AtualizarResumoAudioPortOut atualizarResumoAudioPortOut;

    @InjectMocks
    private AtualizarResumoAudioUseCase atualizarResumoAudioUseCase;

    @Test
    void deveAtualizarResumoAudioDto()
            throws ResumoAudioNaoEncontradoException, IdResumoAudioObrigatorioException {

        final ResumoAudioDTO resumoAudioConsultado =
                ResumoAudioStub.getResumoAudioCompleta();

        when(consultarResumoAudioPortOut.consultar(anyInt()))
                .thenReturn(resumoAudioConsultado);

        final ResumoAudioDTO resumoAudioAtualizado =
                ResumoAudioStub.getResumoAudioAlterada();

        when(atualizarResumoAudioPortOut.atualizar(any(ResumoAudioDTO.class)))
                .thenReturn(resumoAudioAtualizado);

        final ResumoAudioDTO resumoAudioASerAtualizado =
                ResumoAudioStub.getResumoAudioCompleta();

        final ResumoAudioDTO resultadoDaAtualizacao =
                atualizarResumoAudioUseCase.atualizar(resumoAudioASerAtualizado);

        final ArgumentCaptor<ResumoAudioDTO> capturador =
                ArgumentCaptor.forClass(ResumoAudioDTO.class);

        verify(atualizarResumoAudioPortOut).atualizar(capturador.capture());

        final ResumoAudioDTO resumoAudioRecebidoNoAtualizar =
                capturador.getValue();

        assertEquals(
                resumoAudioConsultado.getDataCriacao(),
                resumoAudioRecebidoNoAtualizar.getDataCriacao()
        );

        verify(consultarResumoAudioPortOut).consultar(anyInt());
        verify(atualizarResumoAudioPortOut).atualizar(any(ResumoAudioDTO.class));

        assertNotNull(resultadoDaAtualizacao);
    }

    @Test
    void deveLancarAExcecaoIdResumoAudioObrigatorioQuandoIdAudioForNulo() {

        final ResumoAudioDTO resumoAudioDTO = new ResumoAudioDTO();

        assertThrows(
                IdResumoAudioObrigatorioException.class,
                () -> atualizarResumoAudioUseCase.atualizar(resumoAudioDTO)
        );
    }

    @Test
    void deveLancarAExcecaoResumoAudioNaoEncontradoQuandoResumoAudioNaoExistirNaBase()
            throws ResumoAudioNaoEncontradoException {

        when(consultarResumoAudioPortOut.consultar(anyInt()))
                .thenThrow(ResumoAudioNaoEncontradoException.class);

        final ResumoAudioDTO resumoAudioDTO =
                ResumoAudioStub.getResumoAudioCompleta();

        assertThrows(
                ResumoAudioNaoEncontradoException.class,
                () -> atualizarResumoAudioUseCase.atualizar(resumoAudioDTO)
        );
    }
}