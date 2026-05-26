package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.TurmaDto;
import br.com.olharpedagogicoia.application.exceptions.IdTurmaObrigatorioException;
import br.com.olharpedagogicoia.application.exceptions.TurmaNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.out.AtualizarTurmaPortOut;
import br.com.olharpedagogicoia.application.port.out.ConsultarTurmaPortOut;
import br.com.olharpedagogicoia.application.stub.TurmaStub;
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
public class AtualizarTurmaUseCaseTest {

    @Mock
    private ConsultarTurmaPortOut consultarTurmaPortOut;

    @Spy
    private AtualizarTurmaPortOut atualizarTurmaPortOut;

    @InjectMocks
    private AtualizarTurmaUseCase atualizarTurmaUseCase;

    @Test
    void deveAtualizarTurmaDto() throws TurmaNaoEncontradaException, IdTurmaObrigatorioException {

        final TurmaDto turmaConsultada = TurmaStub.getTurmaCompleta();
        when(consultarTurmaPortOut.consultar(anyInt())).thenReturn(turmaConsultada);

        final TurmaDto turmaAtualizada = TurmaStub.getTurmaAlterada();
        when(atualizarTurmaPortOut.atualizar(any(TurmaDto.class))).thenReturn(turmaAtualizada);

        final TurmaDto turmaASerAtualizada = TurmaStub.getTurmaCompleta();
        final TurmaDto resultadoDaAtualizacao = atualizarTurmaUseCase.atualizar(turmaASerAtualizada);

        final ArgumentCaptor<TurmaDto> capturador = ArgumentCaptor.forClass(TurmaDto.class);
        verify(atualizarTurmaPortOut).atualizar(capturador.capture());

        final TurmaDto turmaRecebidaNoAtualizar = capturador.getValue();

        assertEquals(
                turmaConsultada.getDataCriacao(),
                turmaRecebidaNoAtualizar.getDataCriacao()
        );

        assertNotEquals(
                turmaConsultada.getDataModificacao(),
                turmaRecebidaNoAtualizar.getDataModificacao()
        );

        verify(consultarTurmaPortOut).consultar(anyInt());
        verify(atualizarTurmaPortOut).atualizar(any(TurmaDto.class));

        assertNotNull(resultadoDaAtualizacao);
    }

    @Test
    void deveLancarAExcecaoIdTurmaObrigatorioQuandoIdTurmaForNulo() {
        final TurmaDto turma = new TurmaDto();

        assertThrows(
                IdTurmaObrigatorioException.class,
                () -> atualizarTurmaUseCase.atualizar(turma)
        );
    }

    @Test
    void deveLancarAExcecaoTurmaNaoEncontradaQuandoATurmaNaoExistirNaBase()
            throws TurmaNaoEncontradaException, IdTurmaObrigatorioException {

        when(consultarTurmaPortOut.consultar(anyInt()))
                .thenThrow(TurmaNaoEncontradaException.class);

        final TurmaDto turma = TurmaStub.getTurmaCompleta();

        assertThrows(
                TurmaNaoEncontradaException.class,
                () -> atualizarTurmaUseCase.atualizar(turma)
        );
    }
}