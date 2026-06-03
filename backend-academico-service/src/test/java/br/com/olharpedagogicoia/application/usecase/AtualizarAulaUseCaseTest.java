package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.AulaDTO;
import br.com.olharpedagogicoia.application.exceptions.AulaNaoEncontradaException;
import br.com.olharpedagogicoia.application.exceptions.IdAulaObrigatorioException;
import br.com.olharpedagogicoia.application.port.out.AtualizarAulaPortOut;
import br.com.olharpedagogicoia.application.port.out.ConsultarAulaPortOut;
import br.com.olharpedagogicoia.application.stub.AulaStub;
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
public class AtualizarAulaUseCaseTest {

    @Mock
    private ConsultarAulaPortOut consultarAulaPortOut;

    @Spy
    private AtualizarAulaPortOut atualizarAulaPortOut;

    @InjectMocks
    private AtualizarAulaUseCase atualizarAulaUseCase;

    @Test
    void deveAtualizarAulaDto() throws AulaNaoEncontradaException, IdAulaObrigatorioException {

        final AulaDTO aulaConsultada = AulaStub.getAulaCompleta();
        when(consultarAulaPortOut.consultar(anyInt())).thenReturn(aulaConsultada);

        final AulaDTO aulaAtualizada = AulaStub.getAulaAlterada();
        when(atualizarAulaPortOut.atualizar(any(AulaDTO.class))).thenReturn(aulaAtualizada);

        final AulaDTO aulaASerAtualizada = AulaStub.getAulaCompleta();

        final AulaDTO resultadoDaAtualizacao =
                atualizarAulaUseCase.atualizar(aulaASerAtualizada);

        final ArgumentCaptor<AulaDTO> capturador =
                ArgumentCaptor.forClass(AulaDTO.class);

        verify(atualizarAulaPortOut).atualizar(capturador.capture());

        final AulaDTO aulaRecebidaNoAtualizar = capturador.getValue();

        assertEquals(
                aulaConsultada.getDataCriacao(),
                aulaRecebidaNoAtualizar.getDataCriacao()
        );

        verify(consultarAulaPortOut).consultar(anyInt());
        verify(atualizarAulaPortOut).atualizar(any(AulaDTO.class));

        assertNotNull(resultadoDaAtualizacao);
    }

    @Test
    void deveLancarAExcecaoIdAulaObrigatorioQuandoIdAulaForNulo() {

        final AulaDTO aulaDTO = new AulaDTO();

        assertThrows(
                IdAulaObrigatorioException.class,
                () -> atualizarAulaUseCase.atualizar(aulaDTO)
        );
    }

    @Test
    void deveLancarAExcecaoAulaNaoEncontradaQuandoAulaNaoExistirNaBase()
            throws AulaNaoEncontradaException {

        when(consultarAulaPortOut.consultar(anyInt()))
                .thenThrow(AulaNaoEncontradaException.class);

        final AulaDTO aulaDTO = AulaStub.getAulaCompleta();

        assertThrows(
                AulaNaoEncontradaException.class,
                () -> atualizarAulaUseCase.atualizar(aulaDTO)
        );
    }
}