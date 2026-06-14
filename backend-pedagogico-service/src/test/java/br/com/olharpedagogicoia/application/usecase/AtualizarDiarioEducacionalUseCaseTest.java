package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.DiarioEducacionalDTO;
import br.com.olharpedagogicoia.application.exceptions.DiarioEducacionalNaoEncontradoException;
import br.com.olharpedagogicoia.application.exceptions.IdDiarioEducacionalObrigatorioException;
import br.com.olharpedagogicoia.application.port.out.AtualizarDiarioEducacionalPortOut;
import br.com.olharpedagogicoia.application.port.out.ConsultarDiarioEducacionalPortOut;
import br.com.olharpedagogicoia.application.stub.DiarioEducacionalStub;
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
public class AtualizarDiarioEducacionalUseCaseTest {

    @Mock
    private ConsultarDiarioEducacionalPortOut consultarDiarioEducacionalPortOut;

    @Spy
    private AtualizarDiarioEducacionalPortOut atualizarDiarioEducacionalPortOut;

    @InjectMocks
    private AtualizarDiarioEducacionalUseCase atualizarDiarioEducacionalUseCase;

    @Test
    void deveAtualizarDiarioEducacionalDto()
            throws DiarioEducacionalNaoEncontradoException, IdDiarioEducacionalObrigatorioException {

        final DiarioEducacionalDTO diarioEducacionalConsultado =
                DiarioEducacionalStub.getDiarioEducacionalCompleta();

        when(consultarDiarioEducacionalPortOut.consultar(anyInt()))
                .thenReturn(diarioEducacionalConsultado);

        final DiarioEducacionalDTO diarioEducacionalAtualizado =
                DiarioEducacionalStub.getDiarioEducacionalAlterada();

        when(atualizarDiarioEducacionalPortOut.atualizar(any(DiarioEducacionalDTO.class)))
                .thenReturn(diarioEducacionalAtualizado);

        final DiarioEducacionalDTO diarioEducacionalASerAtualizado =
                DiarioEducacionalStub.getDiarioEducacionalCompleta();

        final DiarioEducacionalDTO resultadoDaAtualizacao =
                atualizarDiarioEducacionalUseCase.atualizar(diarioEducacionalASerAtualizado);

        final ArgumentCaptor<DiarioEducacionalDTO> capturador =
                ArgumentCaptor.forClass(DiarioEducacionalDTO.class);

        verify(atualizarDiarioEducacionalPortOut).atualizar(capturador.capture());

        final DiarioEducacionalDTO diarioEducacionalRecebidoNoAtualizar =
                capturador.getValue();

        assertEquals(
                diarioEducacionalConsultado.getDataCriacao(),
                diarioEducacionalRecebidoNoAtualizar.getDataCriacao()
        );

        verify(consultarDiarioEducacionalPortOut).consultar(anyInt());
        verify(atualizarDiarioEducacionalPortOut).atualizar(any(DiarioEducacionalDTO.class));

        assertNotNull(resultadoDaAtualizacao);
    }

    @Test
    void deveLancarAExcecaoIdDiarioEducacionalObrigatorioQuandoIdDiarioForNulo() {

        final DiarioEducacionalDTO diarioEducacionalDTO = new DiarioEducacionalDTO();

        assertThrows(
                IdDiarioEducacionalObrigatorioException.class,
                () -> atualizarDiarioEducacionalUseCase.atualizar(diarioEducacionalDTO)
        );
    }

    @Test
    void deveLancarAExcecaoDiarioEducacionalNaoEncontradoQuandoDiarioEducacionalNaoExistirNaBase()
            throws DiarioEducacionalNaoEncontradoException {

        when(consultarDiarioEducacionalPortOut.consultar(anyInt()))
                .thenThrow(DiarioEducacionalNaoEncontradoException.class);

        final DiarioEducacionalDTO diarioEducacionalDTO =
                DiarioEducacionalStub.getDiarioEducacionalCompleta();

        assertThrows(
                DiarioEducacionalNaoEncontradoException.class,
                () -> atualizarDiarioEducacionalUseCase.atualizar(diarioEducacionalDTO)
        );
    }
}