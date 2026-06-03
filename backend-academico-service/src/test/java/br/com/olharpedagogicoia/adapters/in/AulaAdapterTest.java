package br.com.olharpedagogicoia.adapters.in;

import br.com.olharpedagogicoia.application.dto.AulaDTO;
import br.com.olharpedagogicoia.application.exceptions.AulaNaoEncontradaException;
import br.com.olharpedagogicoia.application.exceptions.IdAulaObrigatorioException;
import br.com.olharpedagogicoia.application.port.in.AtualizarAulaPortIn;
import br.com.olharpedagogicoia.application.port.in.CadastrarAulaPortIn;
import br.com.olharpedagogicoia.application.port.in.ConsultarAulaPortIn;
import br.com.olharpedagogicoia.application.port.in.RemoverAulaPortIn;
import br.com.olharpedagogicoia.application.stub.AulaStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AulaAdapterTest {

    @Mock
    private ConsultarAulaPortIn consultarAulaPortIn;

    @Mock
    private RemoverAulaPortIn removerAulaPortIn;

    @Mock
    private CadastrarAulaPortIn cadastrarAulaPortIn;

    @Mock
    private AtualizarAulaPortIn atualizarAulaPortIn;

    @InjectMocks
    private AulaAdapter aulaAdapter;

    @Test
    void deveConsultarAulaComSucesso() throws AulaNaoEncontradaException {

        final AulaDTO aulaConsultada = AulaStub.getAulaCompleta();

        when(consultarAulaPortIn.consultar(1)).thenReturn(aulaConsultada);

        final ResponseEntity<?> resposta = aulaAdapter.consultaAula(1);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(200), resposta.getStatusCode());
        assertEquals(aulaConsultada, resposta.getBody());

        verify(consultarAulaPortIn).consultar(1);
    }

    @Test
    void deveLancarExcecaoQuandoNaoEncontrarAulaNaConsulta() throws AulaNaoEncontradaException {

        when(consultarAulaPortIn.consultar(anyInt()))
                .thenThrow(AulaNaoEncontradaException.class);

        final ResponseEntity<?> erro = aulaAdapter.consultaAula(1);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(consultarAulaPortIn).consultar(1);
    }

    @Test
    void deveCadastrarAulaComSucesso() {

        final AulaDTO aulaCadastrada = AulaStub.getAulaCompleta();

        when(cadastrarAulaPortIn.cadastrar(any(AulaDTO.class))).thenReturn(aulaCadastrada);

        final ResponseEntity<AulaDTO> resposta = aulaAdapter.cadastraAula(aulaCadastrada);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(201), resposta.getStatusCode());
        assertEquals(aulaCadastrada, resposta.getBody());

        verify(cadastrarAulaPortIn).cadastrar(aulaCadastrada);
    }

    @Test
    void deveRemoverAulaComSucesso() throws AulaNaoEncontradaException {

        final ResponseEntity<?> resposta = aulaAdapter.removerAula(1);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(202), resposta.getStatusCode());

        verify(removerAulaPortIn).remover(1);
    }

    @Test
    void deveLancarExcecaoQuandoNaoEncontrarAulaParaRemover() throws AulaNaoEncontradaException {

        doThrow(AulaNaoEncontradaException.class)
                .when(removerAulaPortIn).remover(1);

        final ResponseEntity<?> erro = aulaAdapter.removerAula(1);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(removerAulaPortIn).remover(1);
    }

    @Test
    void deveAtualizarAulaComSucesso() throws AulaNaoEncontradaException, IdAulaObrigatorioException {

        final AulaDTO aulaAtualizada = AulaStub.getAulaCompleta();

        when(atualizarAulaPortIn.atualizar(any(AulaDTO.class))).thenReturn(aulaAtualizada);

        final ResponseEntity<?> resposta = aulaAdapter.atualizaAula(aulaAtualizada);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(200), resposta.getStatusCode());
        assertEquals(aulaAtualizada, resposta.getBody());

        verify(atualizarAulaPortIn).atualizar(aulaAtualizada);
    }

    @Test
    void deveLancarExcecaoQuandoNaoEncontrarAulaParaAtualizar()
            throws AulaNaoEncontradaException, IdAulaObrigatorioException {

        final AulaDTO aulaDTO = AulaStub.getAulaCompleta();

        when(atualizarAulaPortIn.atualizar(any(AulaDTO.class)))
                .thenThrow(AulaNaoEncontradaException.class);

        final ResponseEntity<?> erro = aulaAdapter.atualizaAula(aulaDTO);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(atualizarAulaPortIn).atualizar(aulaDTO);
    }

    @Test
    void deveLancarExcecaoQuandoIdAulaForObrigatorioNaAtualizacao()
            throws AulaNaoEncontradaException, IdAulaObrigatorioException {

        final AulaDTO aulaDTO = AulaStub.getAulaCompleta();

        when(atualizarAulaPortIn.atualizar(any(AulaDTO.class)))
                .thenThrow(IdAulaObrigatorioException.class);

        final ResponseEntity<?> erro = aulaAdapter.atualizaAula(aulaDTO);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(atualizarAulaPortIn).atualizar(aulaDTO);
    }
}