package br.com.olharpedagogicoia.adapters.in;

import br.com.olharpedagogicoia.application.dto.PessoaDTO;
import br.com.olharpedagogicoia.application.exceptions.IdPessoaObrigatorioException;
import br.com.olharpedagogicoia.application.exceptions.PessoaNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.in.AtualizarPessoaPortIn;
import br.com.olharpedagogicoia.application.port.in.CadastrarPessoaPortIn;
import br.com.olharpedagogicoia.application.port.in.ConsultarPessoaPortIn;
import br.com.olharpedagogicoia.application.port.in.RemoverPessoaPortIn;
import br.com.olharpedagogicoia.application.stub.PessoaStub;
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
public class PessoaAdapterTest {

    @Mock
    private ConsultarPessoaPortIn consultarPessoaPortIn;

    @Mock
    private RemoverPessoaPortIn removerPessoaPortIn;

    @Mock
    private CadastrarPessoaPortIn cadastrarPessoaPortIn;

    @Mock
    private AtualizarPessoaPortIn atualizarPessoaPortIn;

    @InjectMocks
    private PessoaAdapter pessoaAdapter;

    @Test
    void deveConsultarPessoaComSucesso() throws PessoaNaoEncontradaException {

        final PessoaDTO pessoaConsultada = PessoaStub.getPessoaCompleta();

        when(consultarPessoaPortIn.consultar(1)).thenReturn(pessoaConsultada);

        final ResponseEntity<?> resposta = pessoaAdapter.consultaPessoa(1);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(200), resposta.getStatusCode());
        assertEquals(pessoaConsultada, resposta.getBody());

        verify(consultarPessoaPortIn).consultar(1);
    }

    @Test
    void deveLancarExcecaoQuandoNaoEncontrarPessoaNaConsulta() throws PessoaNaoEncontradaException {

        when(consultarPessoaPortIn.consultar(anyInt()))
                .thenThrow(PessoaNaoEncontradaException.class);

        final ResponseEntity<?> erro = pessoaAdapter.consultaPessoa(1);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(consultarPessoaPortIn).consultar(1);
    }

    @Test
    void deveCadastrarPessoaComSucesso() {

        final PessoaDTO pessoaCadastrada = PessoaStub.getPessoaCompleta();

        when(cadastrarPessoaPortIn.cadastrar(any(PessoaDTO.class))).thenReturn(pessoaCadastrada);

        final ResponseEntity<PessoaDTO> resposta = pessoaAdapter.cadastraPessoa(pessoaCadastrada);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(201), resposta.getStatusCode());
        assertEquals(pessoaCadastrada, resposta.getBody());

        verify(cadastrarPessoaPortIn).cadastrar(pessoaCadastrada);
    }

    @Test
    void deveRemoverPessoaComSucesso() throws PessoaNaoEncontradaException {

        final ResponseEntity<?> resposta = pessoaAdapter.removerPessoa(1);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(202), resposta.getStatusCode());

        verify(removerPessoaPortIn).remover(1);
    }

    @Test
    void deveLancarExcecaoQuandoNaoEncontrarPessoaParaRemover() throws PessoaNaoEncontradaException {

        doThrow(PessoaNaoEncontradaException.class)
                .when(removerPessoaPortIn).remover(1);

        final ResponseEntity<?> erro = pessoaAdapter.removerPessoa(1);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(removerPessoaPortIn).remover(1);
    }

    @Test
    void deveAtualizarPessoaComSucesso() throws PessoaNaoEncontradaException, IdPessoaObrigatorioException {

        final PessoaDTO pessoaAtualizada = PessoaStub.getPessoaCompleta();

        when(atualizarPessoaPortIn.atualizar(any(PessoaDTO.class))).thenReturn(pessoaAtualizada);

        final ResponseEntity<?> resposta = pessoaAdapter.atualizaPessoa(pessoaAtualizada);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(200), resposta.getStatusCode());
        assertEquals(pessoaAtualizada, resposta.getBody());

        verify(atualizarPessoaPortIn).atualizar(pessoaAtualizada);
    }

    @Test
    void deveLancarExcecaoQuandoNaoEncontrarPessoaParaAtualizar() throws PessoaNaoEncontradaException, IdPessoaObrigatorioException {

        final PessoaDTO pessoaDTO = PessoaStub.getPessoaCompleta();

        when(atualizarPessoaPortIn.atualizar(any(PessoaDTO.class)))
                .thenThrow(PessoaNaoEncontradaException.class);

        final ResponseEntity<?> erro = pessoaAdapter.atualizaPessoa(pessoaDTO);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(atualizarPessoaPortIn).atualizar(pessoaDTO);
    }

    @Test
    void deveLancarExcecaoQuandoIdPessoaForObrigatorioNaAtualizacao() throws PessoaNaoEncontradaException, IdPessoaObrigatorioException {

        final PessoaDTO pessoaDTO = PessoaStub.getPessoaCompleta();

        when(atualizarPessoaPortIn.atualizar(any(PessoaDTO.class)))
                .thenThrow(IdPessoaObrigatorioException.class);

        final ResponseEntity<?> erro = pessoaAdapter.atualizaPessoa(pessoaDTO);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(atualizarPessoaPortIn).atualizar(pessoaDTO);
    }
}