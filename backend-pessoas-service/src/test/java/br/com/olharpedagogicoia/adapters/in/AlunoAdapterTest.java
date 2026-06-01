package br.com.olharpedagogicoia.adapters.in;

import br.com.olharpedagogicoia.application.dto.AlunoDTO;
import br.com.olharpedagogicoia.application.exceptions.AlunoNaoEncontradoException;
import br.com.olharpedagogicoia.application.exceptions.IdAlunoObrigatorioException;
import br.com.olharpedagogicoia.application.port.in.AtualizarAlunoPortIn;
import br.com.olharpedagogicoia.application.port.in.CadastrarAlunoPortIn;
import br.com.olharpedagogicoia.application.port.in.ConsultarAlunoPortIn;
import br.com.olharpedagogicoia.application.port.in.RemoverAlunoPortIn;
import br.com.olharpedagogicoia.application.stub.AlunoStub;
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
public class AlunoAdapterTest {

    @Mock
    private ConsultarAlunoPortIn consultarAlunoPortIn;

    @Mock
    private RemoverAlunoPortIn removerAlunoPortIn;

    @Mock
    private CadastrarAlunoPortIn cadastrarAlunoPortIn;

    @Mock
    private AtualizarAlunoPortIn atualizarAlunoPortIn;

    @InjectMocks
    private AlunoAdapter alunoAdapter;

    @Test
    void deveConsultarAlunoComSucesso() throws AlunoNaoEncontradoException {

        final AlunoDTO alunoConsultado = AlunoStub.getAlunoCompleta();

        when(consultarAlunoPortIn.consultar(1)).thenReturn(alunoConsultado);

        final ResponseEntity<?> resposta = alunoAdapter.consultaAluno(1);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(200), resposta.getStatusCode());
        assertEquals(alunoConsultado, resposta.getBody());

        verify(consultarAlunoPortIn).consultar(1);
    }

    @Test
    void deveLancarExcecaoQuandoNaoEncontrarAlunoNaConsulta() throws AlunoNaoEncontradoException {

        when(consultarAlunoPortIn.consultar(anyInt()))
                .thenThrow(AlunoNaoEncontradoException.class);

        final ResponseEntity<?> erro = alunoAdapter.consultaAluno(1);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(consultarAlunoPortIn).consultar(1);
    }

    @Test
    void deveCadastrarAlunoComSucesso() {

        final AlunoDTO alunoCadastrado = AlunoStub.getAlunoCompleta();

        when(cadastrarAlunoPortIn.cadastrar(any(AlunoDTO.class))).thenReturn(alunoCadastrado);

        final ResponseEntity<AlunoDTO> resposta = alunoAdapter.cadastraAluno(alunoCadastrado);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(201), resposta.getStatusCode());
        assertEquals(alunoCadastrado, resposta.getBody());

        verify(cadastrarAlunoPortIn).cadastrar(alunoCadastrado);
    }

    @Test
    void deveRemoverAlunoComSucesso() throws AlunoNaoEncontradoException {

        final ResponseEntity<?> resposta = alunoAdapter.removerAluno(1);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(202), resposta.getStatusCode());

        verify(removerAlunoPortIn).remover(1);
    }

    @Test
    void deveLancarExcecaoQuandoNaoEncontrarAlunoParaRemover() throws AlunoNaoEncontradoException {

        doThrow(AlunoNaoEncontradoException.class)
                .when(removerAlunoPortIn).remover(1);

        final ResponseEntity<?> erro = alunoAdapter.removerAluno(1);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(removerAlunoPortIn).remover(1);
    }

    @Test
    void deveAtualizarAlunoComSucesso() throws AlunoNaoEncontradoException, IdAlunoObrigatorioException {

        final AlunoDTO alunoAtualizado = AlunoStub.getAlunoCompleta();

        when(atualizarAlunoPortIn.atualizar(any(AlunoDTO.class))).thenReturn(alunoAtualizado);

        final ResponseEntity<?> resposta = alunoAdapter.atualizaAluno(alunoAtualizado);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(200), resposta.getStatusCode());
        assertEquals(alunoAtualizado, resposta.getBody());

        verify(atualizarAlunoPortIn).atualizar(alunoAtualizado);
    }

    @Test
    void deveLancarExcecaoQuandoNaoEncontrarAlunoParaAtualizar() throws AlunoNaoEncontradoException, IdAlunoObrigatorioException {

        final AlunoDTO alunoDTO = AlunoStub.getAlunoCompleta();

        when(atualizarAlunoPortIn.atualizar(any(AlunoDTO.class)))
                .thenThrow(AlunoNaoEncontradoException.class);

        final ResponseEntity<?> erro = alunoAdapter.atualizaAluno(alunoDTO);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(atualizarAlunoPortIn).atualizar(alunoDTO);
    }

    @Test
    void deveLancarExcecaoQuandoIdAlunoForObrigatorioNaAtualizacao() throws AlunoNaoEncontradoException, IdAlunoObrigatorioException {

        final AlunoDTO alunoDTO = AlunoStub.getAlunoCompleta();

        when(atualizarAlunoPortIn.atualizar(any(AlunoDTO.class)))
                .thenThrow(IdAlunoObrigatorioException.class);

        final ResponseEntity<?> erro = alunoAdapter.atualizaAluno(alunoDTO);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(atualizarAlunoPortIn).atualizar(alunoDTO);
    }
}