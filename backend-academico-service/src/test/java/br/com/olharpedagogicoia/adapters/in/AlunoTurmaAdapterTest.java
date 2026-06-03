package br.com.olharpedagogicoia.adapters.in;

import br.com.olharpedagogicoia.application.dto.AlunoTurmaDTO;
import br.com.olharpedagogicoia.application.exceptions.AlunoTurmaNaoEncontradaException;
import br.com.olharpedagogicoia.application.exceptions.IdAlunoTurmaObrigatorioException;
import br.com.olharpedagogicoia.application.port.in.AtualizarAlunoTurmaPortIn;
import br.com.olharpedagogicoia.application.port.in.CadastrarAlunoTurmaPortIn;
import br.com.olharpedagogicoia.application.port.in.ConsultarAlunoTurmaPortIn;
import br.com.olharpedagogicoia.application.port.in.RemoverAlunoTurmaPortIn;
import br.com.olharpedagogicoia.application.stub.AlunoTurmaStub;
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
public class AlunoTurmaAdapterTest {

    @Mock
    private ConsultarAlunoTurmaPortIn consultarAlunoTurmaPortIn;

    @Mock
    private RemoverAlunoTurmaPortIn removerAlunoTurmaPortIn;

    @Mock
    private CadastrarAlunoTurmaPortIn cadastrarAlunoTurmaPortIn;

    @Mock
    private AtualizarAlunoTurmaPortIn atualizarAlunoTurmaPortIn;

    @InjectMocks
    private AlunoTurmaAdapter alunoTurmaAdapter;

    @Test
    void deveConsultarAlunoTurmaComSucesso() throws AlunoTurmaNaoEncontradaException {

        final AlunoTurmaDTO alunoTurmaConsultado = AlunoTurmaStub.getAlunoTurmaCompleta();

        when(consultarAlunoTurmaPortIn.consultar(1)).thenReturn(alunoTurmaConsultado);

        final ResponseEntity<?> resposta = alunoTurmaAdapter.consultaAlunoTurma(1);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(200), resposta.getStatusCode());
        assertEquals(alunoTurmaConsultado, resposta.getBody());

        verify(consultarAlunoTurmaPortIn).consultar(1);
    }

    @Test
    void deveLancarExcecaoQuandoNaoEncontrarAlunoTurmaNaConsulta() throws AlunoTurmaNaoEncontradaException {

        when(consultarAlunoTurmaPortIn.consultar(anyInt()))
                .thenThrow(AlunoTurmaNaoEncontradaException.class);

        final ResponseEntity<?> erro = alunoTurmaAdapter.consultaAlunoTurma(1);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(consultarAlunoTurmaPortIn).consultar(1);
    }

    @Test
    void deveCadastrarAlunoTurmaComSucesso() {

        final AlunoTurmaDTO alunoTurmaCadastrado = AlunoTurmaStub.getAlunoTurmaCompleta();

        when(cadastrarAlunoTurmaPortIn.cadastrar(any(AlunoTurmaDTO.class)))
                .thenReturn(alunoTurmaCadastrado);

        final ResponseEntity<AlunoTurmaDTO> resposta =
                alunoTurmaAdapter.cadastraAlunoTurma(alunoTurmaCadastrado);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(201), resposta.getStatusCode());
        assertEquals(alunoTurmaCadastrado, resposta.getBody());

        verify(cadastrarAlunoTurmaPortIn).cadastrar(alunoTurmaCadastrado);
    }

    @Test
    void deveRemoverAlunoTurmaComSucesso() throws AlunoTurmaNaoEncontradaException {

        final ResponseEntity<?> resposta = alunoTurmaAdapter.removerAlunoTurma(1);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(202), resposta.getStatusCode());

        verify(removerAlunoTurmaPortIn).remover(1);
    }

    @Test
    void deveLancarExcecaoQuandoNaoEncontrarAlunoTurmaParaRemover() throws AlunoTurmaNaoEncontradaException {

        doThrow(AlunoTurmaNaoEncontradaException.class)
                .when(removerAlunoTurmaPortIn).remover(1);

        final ResponseEntity<?> erro = alunoTurmaAdapter.removerAlunoTurma(1);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(removerAlunoTurmaPortIn).remover(1);
    }

    @Test
    void deveAtualizarAlunoTurmaComSucesso()
            throws AlunoTurmaNaoEncontradaException, IdAlunoTurmaObrigatorioException {

        final AlunoTurmaDTO alunoTurmaAtualizado = AlunoTurmaStub.getAlunoTurmaCompleta();

        when(atualizarAlunoTurmaPortIn.atualizar(any(AlunoTurmaDTO.class)))
                .thenReturn(alunoTurmaAtualizado);

        final ResponseEntity<?> resposta =
                alunoTurmaAdapter.atualizaAlunoTurma(alunoTurmaAtualizado);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(200), resposta.getStatusCode());
        assertEquals(alunoTurmaAtualizado, resposta.getBody());

        verify(atualizarAlunoTurmaPortIn).atualizar(alunoTurmaAtualizado);
    }

    @Test
    void deveLancarExcecaoQuandoNaoEncontrarAlunoTurmaParaAtualizar()
            throws AlunoTurmaNaoEncontradaException, IdAlunoTurmaObrigatorioException {

        final AlunoTurmaDTO alunoTurmaDTO = AlunoTurmaStub.getAlunoTurmaCompleta();

        when(atualizarAlunoTurmaPortIn.atualizar(any(AlunoTurmaDTO.class)))
                .thenThrow(AlunoTurmaNaoEncontradaException.class);

        final ResponseEntity<?> erro = alunoTurmaAdapter.atualizaAlunoTurma(alunoTurmaDTO);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(atualizarAlunoTurmaPortIn).atualizar(alunoTurmaDTO);
    }

    @Test
    void deveLancarExcecaoQuandoIdAlunoTurmaForObrigatorioNaAtualizacao()
            throws AlunoTurmaNaoEncontradaException, IdAlunoTurmaObrigatorioException {

        final AlunoTurmaDTO alunoTurmaDTO = AlunoTurmaStub.getAlunoTurmaCompleta();

        when(atualizarAlunoTurmaPortIn.atualizar(any(AlunoTurmaDTO.class)))
                .thenThrow(IdAlunoTurmaObrigatorioException.class);

        final ResponseEntity<?> erro = alunoTurmaAdapter.atualizaAlunoTurma(alunoTurmaDTO);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(atualizarAlunoTurmaPortIn).atualizar(alunoTurmaDTO);
    }
}