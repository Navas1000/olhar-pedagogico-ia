package br.com.olharpedagogicoia.adapters.in;

import br.com.olharpedagogicoia.application.dto.ProfessorTurmaDTO;
import br.com.olharpedagogicoia.application.exceptions.IdProfessorTurmaObrigatorioException;
import br.com.olharpedagogicoia.application.exceptions.ProfessorTurmaNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.in.AtualizarProfessorTurmaPortIn;
import br.com.olharpedagogicoia.application.port.in.CadastrarProfessorTurmaPortIn;
import br.com.olharpedagogicoia.application.port.in.ConsultarProfessorTurmaPortIn;
import br.com.olharpedagogicoia.application.port.in.RemoverProfessorTurmaPortIn;
import br.com.olharpedagogicoia.application.stub.ProfessorTurmaStub;
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
public class ProfessorTurmaAdapterTest {

    @Mock
    private ConsultarProfessorTurmaPortIn consultarProfessorTurmaPortIn;

    @Mock
    private RemoverProfessorTurmaPortIn removerProfessorTurmaPortIn;

    @Mock
    private CadastrarProfessorTurmaPortIn cadastrarProfessorTurmaPortIn;

    @Mock
    private AtualizarProfessorTurmaPortIn atualizarProfessorTurmaPortIn;

    @InjectMocks
    private ProfessorTurmaAdapter professorTurmaAdapter;

    @Test
    void deveConsultarProfessorTurmaComSucesso() throws ProfessorTurmaNaoEncontradaException {

        final ProfessorTurmaDTO professorTurmaConsultado = ProfessorTurmaStub.getProfessorTurmaCompleta();

        when(consultarProfessorTurmaPortIn.consultar(1)).thenReturn(professorTurmaConsultado);

        final ResponseEntity<?> resposta = professorTurmaAdapter.consultaProfessorTurma(1);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(200), resposta.getStatusCode());
        assertEquals(professorTurmaConsultado, resposta.getBody());

        verify(consultarProfessorTurmaPortIn).consultar(1);
    }

    @Test
    void deveLancarExcecaoQuandoNaoEncontrarProfessorTurmaNaConsulta()
            throws ProfessorTurmaNaoEncontradaException {

        when(consultarProfessorTurmaPortIn.consultar(anyInt()))
                .thenThrow(ProfessorTurmaNaoEncontradaException.class);

        final ResponseEntity<?> erro = professorTurmaAdapter.consultaProfessorTurma(1);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(consultarProfessorTurmaPortIn).consultar(1);
    }

    @Test
    void deveCadastrarProfessorTurmaComSucesso() {

        final ProfessorTurmaDTO professorTurmaCadastrado = ProfessorTurmaStub.getProfessorTurmaCompleta();

        when(cadastrarProfessorTurmaPortIn.cadastrar(any(ProfessorTurmaDTO.class)))
                .thenReturn(professorTurmaCadastrado);

        final ResponseEntity<ProfessorTurmaDTO> resposta =
                professorTurmaAdapter.cadastraProfessorTurma(professorTurmaCadastrado);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(201), resposta.getStatusCode());
        assertEquals(professorTurmaCadastrado, resposta.getBody());

        verify(cadastrarProfessorTurmaPortIn).cadastrar(professorTurmaCadastrado);
    }

    @Test
    void deveRemoverProfessorTurmaComSucesso() throws ProfessorTurmaNaoEncontradaException {

        final ResponseEntity<?> resposta = professorTurmaAdapter.removerProfessorTurma(1);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(202), resposta.getStatusCode());

        verify(removerProfessorTurmaPortIn).remover(1);
    }

    @Test
    void deveLancarExcecaoQuandoNaoEncontrarProfessorTurmaParaRemover()
            throws ProfessorTurmaNaoEncontradaException {

        doThrow(ProfessorTurmaNaoEncontradaException.class)
                .when(removerProfessorTurmaPortIn).remover(1);

        final ResponseEntity<?> erro = professorTurmaAdapter.removerProfessorTurma(1);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(removerProfessorTurmaPortIn).remover(1);
    }

    @Test
    void deveAtualizarProfessorTurmaComSucesso()
            throws ProfessorTurmaNaoEncontradaException, IdProfessorTurmaObrigatorioException {

        final ProfessorTurmaDTO professorTurmaAtualizado = ProfessorTurmaStub.getProfessorTurmaCompleta();

        when(atualizarProfessorTurmaPortIn.atualizar(any(ProfessorTurmaDTO.class)))
                .thenReturn(professorTurmaAtualizado);

        final ResponseEntity<?> resposta =
                professorTurmaAdapter.atualizaProfessorTurma(professorTurmaAtualizado);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(200), resposta.getStatusCode());
        assertEquals(professorTurmaAtualizado, resposta.getBody());

        verify(atualizarProfessorTurmaPortIn).atualizar(professorTurmaAtualizado);
    }

    @Test
    void deveLancarExcecaoQuandoNaoEncontrarProfessorTurmaParaAtualizar()
            throws ProfessorTurmaNaoEncontradaException, IdProfessorTurmaObrigatorioException {

        final ProfessorTurmaDTO professorTurmaDTO = ProfessorTurmaStub.getProfessorTurmaCompleta();

        when(atualizarProfessorTurmaPortIn.atualizar(any(ProfessorTurmaDTO.class)))
                .thenThrow(ProfessorTurmaNaoEncontradaException.class);

        final ResponseEntity<?> erro = professorTurmaAdapter.atualizaProfessorTurma(professorTurmaDTO);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(atualizarProfessorTurmaPortIn).atualizar(professorTurmaDTO);
    }

    @Test
    void deveLancarExcecaoQuandoIdProfessorTurmaForObrigatorioNaAtualizacao()
            throws ProfessorTurmaNaoEncontradaException, IdProfessorTurmaObrigatorioException {

        final ProfessorTurmaDTO professorTurmaDTO = ProfessorTurmaStub.getProfessorTurmaCompleta();

        when(atualizarProfessorTurmaPortIn.atualizar(any(ProfessorTurmaDTO.class)))
                .thenThrow(IdProfessorTurmaObrigatorioException.class);

        final ResponseEntity<?> erro = professorTurmaAdapter.atualizaProfessorTurma(professorTurmaDTO);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(atualizarProfessorTurmaPortIn).atualizar(professorTurmaDTO);
    }
}