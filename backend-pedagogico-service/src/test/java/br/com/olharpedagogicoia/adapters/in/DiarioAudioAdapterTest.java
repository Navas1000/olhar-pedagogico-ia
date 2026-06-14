package br.com.olharpedagogicoia.adapters.in;

import br.com.olharpedagogicoia.application.dto.DiarioAudioDTO;
import br.com.olharpedagogicoia.application.exceptions.DiarioAudioNaoEncontradoException;
import br.com.olharpedagogicoia.application.exceptions.IdDiarioAudioObrigatorioException;
import br.com.olharpedagogicoia.application.port.in.AtualizarDiarioAudioPortIn;
import br.com.olharpedagogicoia.application.port.in.CadastrarDiarioAudioPortIn;
import br.com.olharpedagogicoia.application.port.in.ConsultarDiarioAudioPortIn;
import br.com.olharpedagogicoia.application.port.in.RemoverDiarioAudioPortIn;
import br.com.olharpedagogicoia.application.stub.DiarioAudioStub;
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
public class DiarioAudioAdapterTest {

    @Mock
    private ConsultarDiarioAudioPortIn consultarDiarioAudioPortIn;

    @Mock
    private CadastrarDiarioAudioPortIn cadastrarDiarioAudioPortIn;

    @Mock
    private RemoverDiarioAudioPortIn removerDiarioAudioPortIn;

    @Mock
    private AtualizarDiarioAudioPortIn atualizarDiarioAudioPortIn;

    @InjectMocks
    private DiarioAudioAdapter diarioAudioAdapter;

    @Test
    void deveConsultarDiarioAudioComSucesso() throws DiarioAudioNaoEncontradoException {

        final DiarioAudioDTO diarioAudioConsultado =
                DiarioAudioStub.getDiarioAudioCompleta();

        when(consultarDiarioAudioPortIn.consultar(1))
                .thenReturn(diarioAudioConsultado);

        final ResponseEntity<?> resposta =
                diarioAudioAdapter.consultaDiarioAudio(1);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(200), resposta.getStatusCode());
        assertEquals(diarioAudioConsultado, resposta.getBody());

        verify(consultarDiarioAudioPortIn).consultar(1);
    }

    @Test
    void deveLancarExcecaoQuandoNaoEncontrarDiarioAudioNaConsulta()
            throws DiarioAudioNaoEncontradoException {

        when(consultarDiarioAudioPortIn.consultar(anyInt()))
                .thenThrow(DiarioAudioNaoEncontradoException.class);

        final ResponseEntity<?> erro =
                diarioAudioAdapter.consultaDiarioAudio(1);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(consultarDiarioAudioPortIn).consultar(1);
    }

    @Test
    void deveCadastrarDiarioAudioComSucesso() {

        final DiarioAudioDTO diarioAudioCadastrado =
                DiarioAudioStub.getDiarioAudioCompleta();

        when(cadastrarDiarioAudioPortIn.cadastrar(any(DiarioAudioDTO.class)))
                .thenReturn(diarioAudioCadastrado);

        final ResponseEntity<DiarioAudioDTO> resposta =
                diarioAudioAdapter.cadastraDiarioAudio(diarioAudioCadastrado);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(201), resposta.getStatusCode());
        assertEquals(diarioAudioCadastrado, resposta.getBody());

        verify(cadastrarDiarioAudioPortIn).cadastrar(diarioAudioCadastrado);
    }

    @Test
    void deveRemoverDiarioAudioComSucesso() throws DiarioAudioNaoEncontradoException {

        final ResponseEntity<?> resposta =
                diarioAudioAdapter.removerDiarioAudio(1);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(202), resposta.getStatusCode());

        verify(removerDiarioAudioPortIn).remover(1);
    }

    @Test
    void deveLancarExcecaoQuandoNaoEncontrarDiarioAudioParaRemover()
            throws DiarioAudioNaoEncontradoException {

        doThrow(DiarioAudioNaoEncontradoException.class)
                .when(removerDiarioAudioPortIn).remover(1);

        final ResponseEntity<?> erro =
                diarioAudioAdapter.removerDiarioAudio(1);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(removerDiarioAudioPortIn).remover(1);
    }

    @Test
    void deveAtualizarDiarioAudioComSucesso()
            throws DiarioAudioNaoEncontradoException, IdDiarioAudioObrigatorioException {

        final DiarioAudioDTO diarioAudioAtualizado =
                DiarioAudioStub.getDiarioAudioCompleta();

        when(atualizarDiarioAudioPortIn.atualizar(any(DiarioAudioDTO.class)))
                .thenReturn(diarioAudioAtualizado);

        final ResponseEntity<?> resposta =
                diarioAudioAdapter.atualizaDiarioAudio(diarioAudioAtualizado);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(200), resposta.getStatusCode());
        assertEquals(diarioAudioAtualizado, resposta.getBody());

        verify(atualizarDiarioAudioPortIn).atualizar(diarioAudioAtualizado);
    }

    @Test
    void deveLancarExcecaoQuandoNaoEncontrarDiarioAudioParaAtualizar()
            throws DiarioAudioNaoEncontradoException, IdDiarioAudioObrigatorioException {

        final DiarioAudioDTO diarioAudioDTO =
                DiarioAudioStub.getDiarioAudioCompleta();

        when(atualizarDiarioAudioPortIn.atualizar(any(DiarioAudioDTO.class)))
                .thenThrow(DiarioAudioNaoEncontradoException.class);

        final ResponseEntity<?> erro =
                diarioAudioAdapter.atualizaDiarioAudio(diarioAudioDTO);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(atualizarDiarioAudioPortIn).atualizar(diarioAudioDTO);
    }

    @Test
    void deveLancarExcecaoQuandoIdDiarioAudioForObrigatorioNaAtualizacao()
            throws DiarioAudioNaoEncontradoException, IdDiarioAudioObrigatorioException {

        final DiarioAudioDTO diarioAudioDTO =
                DiarioAudioStub.getDiarioAudioCompleta();

        when(atualizarDiarioAudioPortIn.atualizar(any(DiarioAudioDTO.class)))
                .thenThrow(IdDiarioAudioObrigatorioException.class);

        final ResponseEntity<?> erro =
                diarioAudioAdapter.atualizaDiarioAudio(diarioAudioDTO);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(atualizarDiarioAudioPortIn).atualizar(diarioAudioDTO);
    }
}