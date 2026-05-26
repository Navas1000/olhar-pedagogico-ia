package br.com.olharpedagogicoia.adapters.in;

import br.com.olharpedagogicoia.application.dto.TurmaDto;
import br.com.olharpedagogicoia.application.exceptions.IdTurmaObrigatorioException;
import br.com.olharpedagogicoia.application.exceptions.TurmaNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.in.AtualizarTurmaPortIn;
import br.com.olharpedagogicoia.application.port.in.CadastrarTurmaPortIn;
import br.com.olharpedagogicoia.application.port.in.ConsultarTurmaPortIn;
import br.com.olharpedagogicoia.application.port.in.RemoverTurmaPortIn;
import br.com.olharpedagogicoia.application.stub.TurmaStub;
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
public class TurmaAdapterTest {

    @Mock
    private ConsultarTurmaPortIn consultarTurmaPortIn;

    @Mock
    private RemoverTurmaPortIn removerTurmaPortIn;

    @Mock
    private CadastrarTurmaPortIn cadastrarTurmaPortIn;

    @Mock
    private AtualizarTurmaPortIn atualizarTurmaPortIn;

    @InjectMocks
    private TurmaAdapter turmaAdapter;

    @Test
    void deveConsultarTurmaComSucesso() throws TurmaNaoEncontradaException {

        final TurmaDto turmaConsultada = TurmaStub.getTurmaCompleta();

        when(consultarTurmaPortIn.consultar(1)).thenReturn(turmaConsultada);

        final ResponseEntity<?> resposta = turmaAdapter.consultaTurma(1);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(200), resposta.getStatusCode());
        assertEquals(turmaConsultada, resposta.getBody());

        verify(consultarTurmaPortIn).consultar(1);
    }

    @Test
    void deveLancarExcecaoQuandoNaoEncontrarTurmaNaConsulta() throws TurmaNaoEncontradaException {

        when(consultarTurmaPortIn.consultar(anyInt()))
                .thenThrow(TurmaNaoEncontradaException.class);

        final ResponseEntity<?> erro = turmaAdapter.consultaTurma(1);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(consultarTurmaPortIn).consultar(1);
    }

    @Test
    void deveCadastrarTurmaComSucesso() {

        final TurmaDto turmaCadastrada = TurmaStub.getTurmaCompleta();

        when(cadastrarTurmaPortIn.cadastrar(any(TurmaDto.class))).thenReturn(turmaCadastrada);

        final ResponseEntity<TurmaDto> resposta = turmaAdapter.cadastraTurma(turmaCadastrada);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(201), resposta.getStatusCode());
        assertEquals(turmaCadastrada, resposta.getBody());

        verify(cadastrarTurmaPortIn).cadastrar(turmaCadastrada);
    }

    @Test
    void deveRemoverTurmaComSucesso() throws TurmaNaoEncontradaException {

        final ResponseEntity<?> resposta = turmaAdapter.removerTurma(1);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(202), resposta.getStatusCode());

        verify(removerTurmaPortIn).remover(1);
    }

    @Test
    void deveLancarExcecaoQuandoNaoEncontrarTurmaParaRemover() throws TurmaNaoEncontradaException {

        doThrow(TurmaNaoEncontradaException.class)
                .when(removerTurmaPortIn).remover(1);

        final ResponseEntity<?> erro = turmaAdapter.removerTurma(1);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(removerTurmaPortIn).remover(1);
    }

    @Test
    void deveAtualizarTurmaComSucesso() throws TurmaNaoEncontradaException, IdTurmaObrigatorioException {

        final TurmaDto turmaAtualizada = TurmaStub.getTurmaCompleta();

        when(atualizarTurmaPortIn.atualizar(any(TurmaDto.class))).thenReturn(turmaAtualizada);

        final ResponseEntity<?> resposta = turmaAdapter.atualizaTurma(turmaAtualizada);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(200), resposta.getStatusCode());
        assertEquals(turmaAtualizada, resposta.getBody());

        verify(atualizarTurmaPortIn).atualizar(turmaAtualizada);
    }

    @Test
    void deveLancarExcecaoQuandoNaoEncontrarTurmaParaAtualizar() throws TurmaNaoEncontradaException, IdTurmaObrigatorioException {

        final TurmaDto turmaDto = TurmaStub.getTurmaCompleta();

        when(atualizarTurmaPortIn.atualizar(any(TurmaDto.class)))
                .thenThrow(TurmaNaoEncontradaException.class);

        final ResponseEntity<?> erro = turmaAdapter.atualizaTurma(turmaDto);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(atualizarTurmaPortIn).atualizar(turmaDto);
    }

    @Test
    void deveLancarExcecaoQuandoIdTurmaForObrigatorioNaAtualizacao() throws TurmaNaoEncontradaException, IdTurmaObrigatorioException {

        final TurmaDto turmaDto = TurmaStub.getTurmaCompleta();

        when(atualizarTurmaPortIn.atualizar(any(TurmaDto.class)))
                .thenThrow(IdTurmaObrigatorioException.class);

        final ResponseEntity<?> erro = turmaAdapter.atualizaTurma(turmaDto);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(atualizarTurmaPortIn).atualizar(turmaDto);
    }
}