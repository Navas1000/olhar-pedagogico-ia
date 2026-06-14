package br.com.olharpedagogicoia.adapters.in;

import br.com.olharpedagogicoia.application.dto.TranscricaoDTO;
import br.com.olharpedagogicoia.application.exceptions.IdTranscricaoObrigatorioException;
import br.com.olharpedagogicoia.application.exceptions.TranscricaoNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.in.AtualizarTranscricaoPortIn;
import br.com.olharpedagogicoia.application.port.in.CadastrarTranscricaoPortIn;
import br.com.olharpedagogicoia.application.port.in.ConsultarTranscricaoPortIn;
import br.com.olharpedagogicoia.application.port.in.RemoverTranscricaoPortIn;
import br.com.olharpedagogicoia.application.stub.TranscricaoStub;
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
public class TranscricaoAdapterTest {

    @Mock
    private ConsultarTranscricaoPortIn consultarTranscricaoPortIn;

    @Mock
    private CadastrarTranscricaoPortIn cadastrarTranscricaoPortIn;

    @Mock
    private RemoverTranscricaoPortIn removerTranscricaoPortIn;

    @Mock
    private AtualizarTranscricaoPortIn atualizarTranscricaoPortIn;

    @InjectMocks
    private TranscricaoAdapter transcricaoAdapter;

    @Test
    void deveConsultarTranscricaoComSucesso() throws TranscricaoNaoEncontradaException {

        final TranscricaoDTO transcricaoConsultada =
                TranscricaoStub.getTranscricaoCompleta();

        when(consultarTranscricaoPortIn.consultar(1))
                .thenReturn(transcricaoConsultada);

        final ResponseEntity<?> resposta =
                transcricaoAdapter.consultaTranscricao(1);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(200), resposta.getStatusCode());
        assertEquals(transcricaoConsultada, resposta.getBody());

        verify(consultarTranscricaoPortIn).consultar(1);
    }

    @Test
    void deveLancarExcecaoQuandoNaoEncontrarTranscricaoNaConsulta()
            throws TranscricaoNaoEncontradaException {

        when(consultarTranscricaoPortIn.consultar(anyInt()))
                .thenThrow(TranscricaoNaoEncontradaException.class);

        final ResponseEntity<?> erro =
                transcricaoAdapter.consultaTranscricao(1);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(consultarTranscricaoPortIn).consultar(1);
    }

    @Test
    void deveCadastrarTranscricaoComSucesso() {

        final TranscricaoDTO transcricaoCadastrada =
                TranscricaoStub.getTranscricaoCompleta();

        when(cadastrarTranscricaoPortIn.cadastrar(any(TranscricaoDTO.class)))
                .thenReturn(transcricaoCadastrada);

        final ResponseEntity<TranscricaoDTO> resposta =
                transcricaoAdapter.cadastraTranscricao(transcricaoCadastrada);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(201), resposta.getStatusCode());
        assertEquals(transcricaoCadastrada, resposta.getBody());

        verify(cadastrarTranscricaoPortIn).cadastrar(transcricaoCadastrada);
    }

    @Test
    void deveRemoverTranscricaoComSucesso() throws TranscricaoNaoEncontradaException {

        final ResponseEntity<?> resposta =
                transcricaoAdapter.removerTranscricao(1);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(202), resposta.getStatusCode());

        verify(removerTranscricaoPortIn).remover(1);
    }

    @Test
    void deveLancarExcecaoQuandoNaoEncontrarTranscricaoParaRemover()
            throws TranscricaoNaoEncontradaException {

        doThrow(TranscricaoNaoEncontradaException.class)
                .when(removerTranscricaoPortIn).remover(1);

        final ResponseEntity<?> erro =
                transcricaoAdapter.removerTranscricao(1);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(removerTranscricaoPortIn).remover(1);
    }

    @Test
    void deveAtualizarTranscricaoComSucesso()
            throws TranscricaoNaoEncontradaException, IdTranscricaoObrigatorioException {

        final TranscricaoDTO transcricaoAtualizada =
                TranscricaoStub.getTranscricaoCompleta();

        when(atualizarTranscricaoPortIn.atualizar(any(TranscricaoDTO.class)))
                .thenReturn(transcricaoAtualizada);

        final ResponseEntity<?> resposta =
                transcricaoAdapter.atualizaTranscricao(transcricaoAtualizada);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(200), resposta.getStatusCode());
        assertEquals(transcricaoAtualizada, resposta.getBody());

        verify(atualizarTranscricaoPortIn).atualizar(transcricaoAtualizada);
    }

    @Test
    void deveLancarExcecaoQuandoNaoEncontrarTranscricaoParaAtualizar()
            throws TranscricaoNaoEncontradaException, IdTranscricaoObrigatorioException {

        final TranscricaoDTO transcricaoDTO =
                TranscricaoStub.getTranscricaoCompleta();

        when(atualizarTranscricaoPortIn.atualizar(any(TranscricaoDTO.class)))
                .thenThrow(TranscricaoNaoEncontradaException.class);

        final ResponseEntity<?> erro =
                transcricaoAdapter.atualizaTranscricao(transcricaoDTO);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(atualizarTranscricaoPortIn).atualizar(transcricaoDTO);
    }

    @Test
    void deveLancarExcecaoQuandoIdTranscricaoForObrigatorioNaAtualizacao()
            throws TranscricaoNaoEncontradaException, IdTranscricaoObrigatorioException {

        final TranscricaoDTO transcricaoDTO =
                TranscricaoStub.getTranscricaoCompleta();

        when(atualizarTranscricaoPortIn.atualizar(any(TranscricaoDTO.class)))
                .thenThrow(IdTranscricaoObrigatorioException.class);

        final ResponseEntity<?> erro =
                transcricaoAdapter.atualizaTranscricao(transcricaoDTO);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(atualizarTranscricaoPortIn).atualizar(transcricaoDTO);
    }
}