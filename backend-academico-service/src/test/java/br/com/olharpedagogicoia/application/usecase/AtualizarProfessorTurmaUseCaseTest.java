package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.ProfessorTurmaDTO;
import br.com.olharpedagogicoia.application.exceptions.IdProfessorTurmaObrigatorioException;
import br.com.olharpedagogicoia.application.exceptions.ProfessorTurmaNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.out.AtualizarProfessorTurmaPortOut;
import br.com.olharpedagogicoia.application.port.out.ConsultarProfessorTurmaPortOut;
import br.com.olharpedagogicoia.application.stub.ProfessorTurmaStub;
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
public class AtualizarProfessorTurmaUseCaseTest {

    @Mock
    private ConsultarProfessorTurmaPortOut consultarProfessorTurmaPortOut;

    @Spy
    private AtualizarProfessorTurmaPortOut atualizarProfessorTurmaPortOut;

    @InjectMocks
    private AtualizarProfessorTurmaUseCase atualizarProfessorTurmaUseCase;

    @Test
    void deveAtualizarProfessorTurmaDto()
            throws ProfessorTurmaNaoEncontradaException, IdProfessorTurmaObrigatorioException {

        final ProfessorTurmaDTO professorTurmaConsultado =
                ProfessorTurmaStub.getProfessorTurmaCompleta();

        when(consultarProfessorTurmaPortOut.consultar(anyInt()))
                .thenReturn(professorTurmaConsultado);

        final ProfessorTurmaDTO professorTurmaAtualizado =
                ProfessorTurmaStub.getProfessorTurmaAlterada();

        when(atualizarProfessorTurmaPortOut.atualizar(any(ProfessorTurmaDTO.class)))
                .thenReturn(professorTurmaAtualizado);

        final ProfessorTurmaDTO professorTurmaASerAtualizado =
                ProfessorTurmaStub.getProfessorTurmaCompleta();

        final ProfessorTurmaDTO resultadoDaAtualizacao =
                atualizarProfessorTurmaUseCase.atualizar(professorTurmaASerAtualizado);

        final ArgumentCaptor<ProfessorTurmaDTO> capturador =
                ArgumentCaptor.forClass(ProfessorTurmaDTO.class);

        verify(atualizarProfessorTurmaPortOut).atualizar(capturador.capture());

        final ProfessorTurmaDTO professorTurmaRecebidoNoAtualizar = capturador.getValue();

        assertEquals(
                professorTurmaConsultado.getDataCriacao(),
                professorTurmaRecebidoNoAtualizar.getDataCriacao()
        );

        verify(consultarProfessorTurmaPortOut).consultar(anyInt());
        verify(atualizarProfessorTurmaPortOut).atualizar(any(ProfessorTurmaDTO.class));

        assertNotNull(resultadoDaAtualizacao);
    }

    @Test
    void deveLancarAExcecaoIdProfessorTurmaObrigatorioQuandoIdAlocacaoForNulo() {

        final ProfessorTurmaDTO professorTurmaDTO = new ProfessorTurmaDTO();

        assertThrows(
                IdProfessorTurmaObrigatorioException.class,
                () -> atualizarProfessorTurmaUseCase.atualizar(professorTurmaDTO)
        );
    }

    @Test
    void deveLancarAExcecaoProfessorTurmaNaoEncontradaQuandoProfessorTurmaNaoExistirNaBase()
            throws ProfessorTurmaNaoEncontradaException {

        when(consultarProfessorTurmaPortOut.consultar(anyInt()))
                .thenThrow(ProfessorTurmaNaoEncontradaException.class);

        final ProfessorTurmaDTO professorTurmaDTO =
                ProfessorTurmaStub.getProfessorTurmaCompleta();

        assertThrows(
                ProfessorTurmaNaoEncontradaException.class,
                () -> atualizarProfessorTurmaUseCase.atualizar(professorTurmaDTO)
        );
    }
}