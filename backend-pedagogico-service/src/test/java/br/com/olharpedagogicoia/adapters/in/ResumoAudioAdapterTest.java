package br.com.olharpedagogicoia.adapters.in;

import br.com.olharpedagogicoia.application.dto.ResumoAudioDTO;
import br.com.olharpedagogicoia.application.exceptions.IdResumoAudioObrigatorioException;
import br.com.olharpedagogicoia.application.exceptions.ResumoAudioNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.in.AtualizarResumoAudioPortIn;
import br.com.olharpedagogicoia.application.port.in.CadastrarResumoAudioPortIn;
import br.com.olharpedagogicoia.application.port.in.ConsultarResumoAudioPortIn;
import br.com.olharpedagogicoia.application.port.in.RemoverResumoAudioPortIn;
import br.com.olharpedagogicoia.application.stub.ResumoAudioStub;
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
public class ResumoAudioAdapterTest {

    @Mock
    private ConsultarResumoAudioPortIn consultarResumoAudioPortIn;

    @Mock
    private CadastrarResumoAudioPortIn cadastrarResumoAudioPortIn;

    @Mock
    private RemoverResumoAudioPortIn removerResumoAudioPortIn;

    @Mock
    private AtualizarResumoAudioPortIn atualizarResumoAudioPortIn;

    @InjectMocks
    private ResumoAudioAdapter resumoAudioAdapter;

    @Test
    void deveConsultarResumoAudioComSucesso() throws ResumoAudioNaoEncontradoException {

        final ResumoAudioDTO resumoAudioConsultado =
                ResumoAudioStub.getResumoAudioCompleta();

        when(consultarResumoAudioPortIn.consultar(1))
                .thenReturn(resumoAudioConsultado);

        final ResponseEntity<?> resposta =
                resumoAudioAdapter.consultaResumoAudio(1);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(200), resposta.getStatusCode());
        assertEquals(resumoAudioConsultado, resposta.getBody());

        verify(consultarResumoAudioPortIn).consultar(1);
    }

    @Test
    void deveLancarExcecaoQuandoNaoEncontrarResumoAudioNaConsulta()
            throws ResumoAudioNaoEncontradoException {

        when(consultarResumoAudioPortIn.consultar(anyInt()))
                .thenThrow(ResumoAudioNaoEncontradoException.class);

        final ResponseEntity<?> erro =
                resumoAudioAdapter.consultaResumoAudio(1);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(consultarResumoAudioPortIn).consultar(1);
    }

    @Test
    void deveCadastrarResumoAudioComSucesso() {

        final ResumoAudioDTO resumoAudioCadastrado =
                ResumoAudioStub.getResumoAudioCompleta();

        when(cadastrarResumoAudioPortIn.cadastrar(any(ResumoAudioDTO.class)))
                .thenReturn(resumoAudioCadastrado);

        final ResponseEntity<ResumoAudioDTO> resposta =
                resumoAudioAdapter.cadastraResumoAudio(resumoAudioCadastrado);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(201), resposta.getStatusCode());
        assertEquals(resumoAudioCadastrado, resposta.getBody());

        verify(cadastrarResumoAudioPortIn).cadastrar(resumoAudioCadastrado);
    }

    @Test
    void deveRemoverResumoAudioComSucesso() throws ResumoAudioNaoEncontradoException {

        final ResponseEntity<?> resposta =
                resumoAudioAdapter.removerResumoAudio(1);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(202), resposta.getStatusCode());

        verify(removerResumoAudioPortIn).remover(1);
    }

    @Test
    void deveLancarExcecaoQuandoNaoEncontrarResumoAudioParaRemover()
            throws ResumoAudioNaoEncontradoException {

        doThrow(ResumoAudioNaoEncontradoException.class)
                .when(removerResumoAudioPortIn).remover(1);

        final ResponseEntity<?> erro =
                resumoAudioAdapter.removerResumoAudio(1);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(removerResumoAudioPortIn).remover(1);
    }

    @Test
    void deveAtualizarResumoAudioComSucesso()
            throws ResumoAudioNaoEncontradoException, IdResumoAudioObrigatorioException {

        final ResumoAudioDTO resumoAudioAtualizado =
                ResumoAudioStub.getResumoAudioCompleta();

        when(atualizarResumoAudioPortIn.atualizar(any(ResumoAudioDTO.class)))
                .thenReturn(resumoAudioAtualizado);

        final ResponseEntity<?> resposta =
                resumoAudioAdapter.atualizaResumoAudio(resumoAudioAtualizado);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(200), resposta.getStatusCode());
        assertEquals(resumoAudioAtualizado, resposta.getBody());

        verify(atualizarResumoAudioPortIn).atualizar(resumoAudioAtualizado);
    }

    @Test
    void deveLancarExcecaoQuandoNaoEncontrarResumoAudioParaAtualizar()
            throws ResumoAudioNaoEncontradoException, IdResumoAudioObrigatorioException {

        final ResumoAudioDTO resumoAudioDTO =
                ResumoAudioStub.getResumoAudioCompleta();

        when(atualizarResumoAudioPortIn.atualizar(any(ResumoAudioDTO.class)))
                .thenThrow(ResumoAudioNaoEncontradoException.class);

        final ResponseEntity<?> erro =
                resumoAudioAdapter.atualizaResumoAudio(resumoAudioDTO);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(atualizarResumoAudioPortIn).atualizar(resumoAudioDTO);
    }

    @Test
    void deveLancarExcecaoQuandoIdResumoAudioForObrigatorioNaAtualizacao()
            throws ResumoAudioNaoEncontradoException, IdResumoAudioObrigatorioException {

        final ResumoAudioDTO resumoAudioDTO =
                ResumoAudioStub.getResumoAudioCompleta();

        when(atualizarResumoAudioPortIn.atualizar(any(ResumoAudioDTO.class)))
                .thenThrow(IdResumoAudioObrigatorioException.class);

        final ResponseEntity<?> erro =
                resumoAudioAdapter.atualizaResumoAudio(resumoAudioDTO);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(atualizarResumoAudioPortIn).atualizar(resumoAudioDTO);
    }
}