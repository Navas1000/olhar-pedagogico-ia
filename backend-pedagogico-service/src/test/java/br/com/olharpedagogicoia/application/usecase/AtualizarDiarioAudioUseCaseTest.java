package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.DiarioAudioDTO;
import br.com.olharpedagogicoia.application.exceptions.DiarioAudioNaoEncontradoException;
import br.com.olharpedagogicoia.application.exceptions.IdDiarioAudioObrigatorioException;
import br.com.olharpedagogicoia.application.port.out.AtualizarDiarioAudioPortOut;
import br.com.olharpedagogicoia.application.port.out.ConsultarDiarioAudioPortOut;
import br.com.olharpedagogicoia.application.stub.DiarioAudioStub;
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
public class AtualizarDiarioAudioUseCaseTest {

    @Mock
    private ConsultarDiarioAudioPortOut consultarDiarioAudioPortOut;

    @Spy
    private AtualizarDiarioAudioPortOut atualizarDiarioAudioPortOut;

    @InjectMocks
    private AtualizarDiarioAudioUseCase atualizarDiarioAudioUseCase;

    @Test
    void deveAtualizarDiarioAudioDto()
            throws DiarioAudioNaoEncontradoException, IdDiarioAudioObrigatorioException {

        final DiarioAudioDTO diarioAudioConsultado =
                DiarioAudioStub.getDiarioAudioCompleta();

        when(consultarDiarioAudioPortOut.consultar(anyInt()))
                .thenReturn(diarioAudioConsultado);

        final DiarioAudioDTO diarioAudioAtualizado =
                DiarioAudioStub.getDiarioAudioAlterada();

        when(atualizarDiarioAudioPortOut.atualizar(any(DiarioAudioDTO.class)))
                .thenReturn(diarioAudioAtualizado);

        final DiarioAudioDTO diarioAudioASerAtualizado =
                DiarioAudioStub.getDiarioAudioCompleta();

        final DiarioAudioDTO resultadoDaAtualizacao =
                atualizarDiarioAudioUseCase.atualizar(diarioAudioASerAtualizado);

        final ArgumentCaptor<DiarioAudioDTO> capturador =
                ArgumentCaptor.forClass(DiarioAudioDTO.class);

        verify(atualizarDiarioAudioPortOut).atualizar(capturador.capture());

        final DiarioAudioDTO diarioAudioRecebidoNoAtualizar =
                capturador.getValue();

        assertEquals(
                diarioAudioConsultado.getDataCriacao(),
                diarioAudioRecebidoNoAtualizar.getDataCriacao()
        );

        verify(consultarDiarioAudioPortOut).consultar(anyInt());
        verify(atualizarDiarioAudioPortOut).atualizar(any(DiarioAudioDTO.class));

        assertNotNull(resultadoDaAtualizacao);
    }

    @Test
    void deveLancarAExcecaoIdDiarioAudioObrigatorioQuandoIdAudioForNulo() {

        final DiarioAudioDTO diarioAudioDTO = new DiarioAudioDTO();

        assertThrows(
                IdDiarioAudioObrigatorioException.class,
                () -> atualizarDiarioAudioUseCase.atualizar(diarioAudioDTO)
        );
    }

    @Test
    void deveLancarAExcecaoDiarioAudioNaoEncontradoQuandoDiarioAudioNaoExistirNaBase()
            throws DiarioAudioNaoEncontradoException {

        when(consultarDiarioAudioPortOut.consultar(anyInt()))
                .thenThrow(DiarioAudioNaoEncontradoException.class);

        final DiarioAudioDTO diarioAudioDTO =
                DiarioAudioStub.getDiarioAudioCompleta();

        assertThrows(
                DiarioAudioNaoEncontradoException.class,
                () -> atualizarDiarioAudioUseCase.atualizar(diarioAudioDTO)
        );
    }
}