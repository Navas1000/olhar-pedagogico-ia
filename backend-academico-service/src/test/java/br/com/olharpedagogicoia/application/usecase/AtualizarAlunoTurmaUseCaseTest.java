package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.AlunoTurmaDTO;
import br.com.olharpedagogicoia.application.exceptions.AlunoTurmaNaoEncontradaException;
import br.com.olharpedagogicoia.application.exceptions.IdAlunoTurmaObrigatorioException;
import br.com.olharpedagogicoia.application.port.out.AtualizarAlunoTurmaPortOut;
import br.com.olharpedagogicoia.application.port.out.ConsultarAlunoTurmaPortOut;
import br.com.olharpedagogicoia.application.stub.AlunoTurmaStub;
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
public class AtualizarAlunoTurmaUseCaseTest {

    @Mock
    private ConsultarAlunoTurmaPortOut consultarAlunoTurmaPortOut;

    @Spy
    private AtualizarAlunoTurmaPortOut atualizarAlunoTurmaPortOut;

    @InjectMocks
    private AtualizarAlunoTurmaUseCase atualizarAlunoTurmaUseCase;

    @Test
    void deveAtualizarAlunoTurmaDto() throws AlunoTurmaNaoEncontradaException, IdAlunoTurmaObrigatorioException {

        final AlunoTurmaDTO alunoTurmaConsultado = AlunoTurmaStub.getAlunoTurmaCompleta();
        when(consultarAlunoTurmaPortOut.consultar(anyInt())).thenReturn(alunoTurmaConsultado);

        final AlunoTurmaDTO alunoTurmaAtualizado = AlunoTurmaStub.getAlunoTurmaAlterada();
        when(atualizarAlunoTurmaPortOut.atualizar(any(AlunoTurmaDTO.class))).thenReturn(alunoTurmaAtualizado);

        final AlunoTurmaDTO alunoTurmaASerAtualizado = AlunoTurmaStub.getAlunoTurmaCompleta();

        final AlunoTurmaDTO resultadoDaAtualizacao =
                atualizarAlunoTurmaUseCase.atualizar(alunoTurmaASerAtualizado);

        final ArgumentCaptor<AlunoTurmaDTO> capturador =
                ArgumentCaptor.forClass(AlunoTurmaDTO.class);

        verify(atualizarAlunoTurmaPortOut).atualizar(capturador.capture());

        final AlunoTurmaDTO alunoTurmaRecebidoNoAtualizar = capturador.getValue();

        assertEquals(
                alunoTurmaConsultado.getDataCriacao(),
                alunoTurmaRecebidoNoAtualizar.getDataCriacao()
        );

        verify(consultarAlunoTurmaPortOut).consultar(anyInt());
        verify(atualizarAlunoTurmaPortOut).atualizar(any(AlunoTurmaDTO.class));

        assertNotNull(resultadoDaAtualizacao);
    }

    @Test
    void deveLancarAExcecaoIdAlunoTurmaObrigatorioQuandoIdMatriculaForNulo() {

        final AlunoTurmaDTO alunoTurmaDTO = new AlunoTurmaDTO();

        assertThrows(
                IdAlunoTurmaObrigatorioException.class,
                () -> atualizarAlunoTurmaUseCase.atualizar(alunoTurmaDTO)
        );
    }

    @Test
    void deveLancarAExcecaoAlunoTurmaNaoEncontradaQuandoAlunoTurmaNaoExistirNaBase()
            throws AlunoTurmaNaoEncontradaException {

        when(consultarAlunoTurmaPortOut.consultar(anyInt()))
                .thenThrow(AlunoTurmaNaoEncontradaException.class);

        final AlunoTurmaDTO alunoTurmaDTO = AlunoTurmaStub.getAlunoTurmaCompleta();

        assertThrows(
                AlunoTurmaNaoEncontradaException.class,
                () -> atualizarAlunoTurmaUseCase.atualizar(alunoTurmaDTO)
        );
    }
}