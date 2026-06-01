package br.com.olharpedagogicoia.adapters.in;

import br.com.olharpedagogicoia.application.dto.PapelFuncaoDTO;
import br.com.olharpedagogicoia.application.exceptions.IdPapelFuncaoObrigatorioException;
import br.com.olharpedagogicoia.application.exceptions.PapelFuncaoNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.in.AtualizarPapelFuncaoPortIn;
import br.com.olharpedagogicoia.application.port.in.CadastrarPapelFuncaoPortIn;
import br.com.olharpedagogicoia.application.port.in.ConsultarPapelFuncaoPortIn;
import br.com.olharpedagogicoia.application.port.in.RemoverPapelFuncaoPortIn;
import br.com.olharpedagogicoia.application.stub.PapelFuncaoStub;
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
public class PapelFuncaoAdapterTest {

    @Mock
    private ConsultarPapelFuncaoPortIn consultarPapelFuncaoPortIn;

    @Mock
    private RemoverPapelFuncaoPortIn removerPapelFuncaoPortIn;

    @Mock
    private CadastrarPapelFuncaoPortIn cadastrarPapelFuncaoPortIn;

    @Mock
    private AtualizarPapelFuncaoPortIn atualizarPapelFuncaoPortIn;

    @InjectMocks
    private PapelFuncaoAdapter papelFuncaoAdapter;

    @Test
    void deveConsultarPapelFuncaoComSucesso() throws PapelFuncaoNaoEncontradoException {

        final PapelFuncaoDTO papelFuncaoConsultado = PapelFuncaoStub.getPapelFuncaoCompleta();

        when(consultarPapelFuncaoPortIn.consultar(1)).thenReturn(papelFuncaoConsultado);

        final ResponseEntity<?> resposta = papelFuncaoAdapter.consultaPapelFuncao(1);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(200), resposta.getStatusCode());
        assertEquals(papelFuncaoConsultado, resposta.getBody());

        verify(consultarPapelFuncaoPortIn).consultar(1);
    }

    @Test
    void deveLancarExcecaoQuandoNaoEncontrarPapelFuncaoNaConsulta() throws PapelFuncaoNaoEncontradoException {

        when(consultarPapelFuncaoPortIn.consultar(anyInt()))
                .thenThrow(PapelFuncaoNaoEncontradoException.class);

        final ResponseEntity<?> erro = papelFuncaoAdapter.consultaPapelFuncao(1);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(consultarPapelFuncaoPortIn).consultar(1);
    }

    @Test
    void deveCadastrarPapelFuncaoComSucesso() {

        final PapelFuncaoDTO papelFuncaoCadastrado = PapelFuncaoStub.getPapelFuncaoCompleta();

        when(cadastrarPapelFuncaoPortIn.cadastrar(any(PapelFuncaoDTO.class))).thenReturn(papelFuncaoCadastrado);

        final ResponseEntity<PapelFuncaoDTO> resposta = papelFuncaoAdapter.cadastraPapelFuncao(papelFuncaoCadastrado);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(201), resposta.getStatusCode());
        assertEquals(papelFuncaoCadastrado, resposta.getBody());

        verify(cadastrarPapelFuncaoPortIn).cadastrar(papelFuncaoCadastrado);
    }

    @Test
    void deveRemoverPapelFuncaoComSucesso() throws PapelFuncaoNaoEncontradoException {

        final ResponseEntity<?> resposta = papelFuncaoAdapter.removerPapelFuncao(1);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(202), resposta.getStatusCode());

        verify(removerPapelFuncaoPortIn).remover(1);
    }

    @Test
    void deveLancarExcecaoQuandoNaoEncontrarPapelFuncaoParaRemover() throws PapelFuncaoNaoEncontradoException {

        doThrow(PapelFuncaoNaoEncontradoException.class)
                .when(removerPapelFuncaoPortIn).remover(1);

        final ResponseEntity<?> erro = papelFuncaoAdapter.removerPapelFuncao(1);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(removerPapelFuncaoPortIn).remover(1);
    }

    @Test
    void deveAtualizarPapelFuncaoComSucesso() throws PapelFuncaoNaoEncontradoException, IdPapelFuncaoObrigatorioException {

        final PapelFuncaoDTO papelFuncaoAtualizado = PapelFuncaoStub.getPapelFuncaoCompleta();

        when(atualizarPapelFuncaoPortIn.atualizar(any(PapelFuncaoDTO.class))).thenReturn(papelFuncaoAtualizado);

        final ResponseEntity<?> resposta = papelFuncaoAdapter.atualizaPapelFuncao(papelFuncaoAtualizado);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(200), resposta.getStatusCode());
        assertEquals(papelFuncaoAtualizado, resposta.getBody());

        verify(atualizarPapelFuncaoPortIn).atualizar(papelFuncaoAtualizado);
    }

    @Test
    void deveLancarExcecaoQuandoNaoEncontrarPapelFuncaoParaAtualizar() throws PapelFuncaoNaoEncontradoException, IdPapelFuncaoObrigatorioException {

        final PapelFuncaoDTO papelFuncaoDTO = PapelFuncaoStub.getPapelFuncaoCompleta();

        when(atualizarPapelFuncaoPortIn.atualizar(any(PapelFuncaoDTO.class)))
                .thenThrow(PapelFuncaoNaoEncontradoException.class);

        final ResponseEntity<?> erro = papelFuncaoAdapter.atualizaPapelFuncao(papelFuncaoDTO);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(atualizarPapelFuncaoPortIn).atualizar(papelFuncaoDTO);
    }

    @Test
    void deveLancarExcecaoQuandoIdPapelFuncaoForObrigatorioNaAtualizacao() throws PapelFuncaoNaoEncontradoException, IdPapelFuncaoObrigatorioException {

        final PapelFuncaoDTO papelFuncaoDTO = PapelFuncaoStub.getPapelFuncaoCompleta();

        when(atualizarPapelFuncaoPortIn.atualizar(any(PapelFuncaoDTO.class)))
                .thenThrow(IdPapelFuncaoObrigatorioException.class);

        final ResponseEntity<?> erro = papelFuncaoAdapter.atualizaPapelFuncao(papelFuncaoDTO);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(atualizarPapelFuncaoPortIn).atualizar(papelFuncaoDTO);
    }
}