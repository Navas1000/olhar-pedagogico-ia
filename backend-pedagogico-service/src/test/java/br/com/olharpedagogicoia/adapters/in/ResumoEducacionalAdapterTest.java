package br.com.olharpedagogicoia.adapters.in;

import br.com.olharpedagogicoia.application.dto.ResumoEducacionalDTO;
import br.com.olharpedagogicoia.application.exceptions.IdResumoEducacionalObrigatorioException;
import br.com.olharpedagogicoia.application.exceptions.ResumoEducacionalNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.in.AtualizarResumoEducacionalPortIn;
import br.com.olharpedagogicoia.application.port.in.CadastrarResumoEducacionalPortIn;
import br.com.olharpedagogicoia.application.port.in.ConsultarResumoEducacionalPortIn;
import br.com.olharpedagogicoia.application.port.in.RemoverResumoEducacionalPortIn;
import br.com.olharpedagogicoia.application.stub.ResumoEducacionalStub;
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
public class ResumoEducacionalAdapterTest {

    @Mock
    private ConsultarResumoEducacionalPortIn consultarResumoEducacionalPortIn;

    @Mock
    private CadastrarResumoEducacionalPortIn cadastrarResumoEducacionalPortIn;

    @Mock
    private RemoverResumoEducacionalPortIn removerResumoEducacionalPortIn;

    @Mock
    private AtualizarResumoEducacionalPortIn atualizarResumoEducacionalPortIn;

    @InjectMocks
    private ResumoEducacionalAdapter resumoEducacionalAdapter;

    @Test
    void deveConsultarResumoEducacionalComSucesso() throws ResumoEducacionalNaoEncontradoException {

        final ResumoEducacionalDTO resumoEducacionalConsultado =
                ResumoEducacionalStub.getResumoEducacionalCompleta();

        when(consultarResumoEducacionalPortIn.consultar(1))
                .thenReturn(resumoEducacionalConsultado);

        final ResponseEntity<?> resposta =
                resumoEducacionalAdapter.consultaResumoEducacional(1);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(200), resposta.getStatusCode());
        assertEquals(resumoEducacionalConsultado, resposta.getBody());

        verify(consultarResumoEducacionalPortIn).consultar(1);
    }

    @Test
    void deveLancarExcecaoQuandoNaoEncontrarResumoEducacionalNaConsulta()
            throws ResumoEducacionalNaoEncontradoException {

        when(consultarResumoEducacionalPortIn.consultar(anyInt()))
                .thenThrow(ResumoEducacionalNaoEncontradoException.class);

        final ResponseEntity<?> erro =
                resumoEducacionalAdapter.consultaResumoEducacional(1);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(consultarResumoEducacionalPortIn).consultar(1);
    }

    @Test
    void deveCadastrarResumoEducacionalComSucesso() {

        final ResumoEducacionalDTO resumoEducacionalCadastrado =
                ResumoEducacionalStub.getResumoEducacionalCompleta();

        when(cadastrarResumoEducacionalPortIn.cadastrar(any(ResumoEducacionalDTO.class)))
                .thenReturn(resumoEducacionalCadastrado);

        final ResponseEntity<ResumoEducacionalDTO> resposta =
                resumoEducacionalAdapter.cadastraResumoEducacional(resumoEducacionalCadastrado);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(201), resposta.getStatusCode());
        assertEquals(resumoEducacionalCadastrado, resposta.getBody());

        verify(cadastrarResumoEducacionalPortIn).cadastrar(resumoEducacionalCadastrado);
    }

    @Test
    void deveRemoverResumoEducacionalComSucesso() throws ResumoEducacionalNaoEncontradoException {

        final ResponseEntity<?> resposta =
                resumoEducacionalAdapter.removerResumoEducacional(1);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(202), resposta.getStatusCode());

        verify(removerResumoEducacionalPortIn).remover(1);
    }

    @Test
    void deveLancarExcecaoQuandoNaoEncontrarResumoEducacionalParaRemover()
            throws ResumoEducacionalNaoEncontradoException {

        doThrow(ResumoEducacionalNaoEncontradoException.class)
                .when(removerResumoEducacionalPortIn).remover(1);

        final ResponseEntity<?> erro =
                resumoEducacionalAdapter.removerResumoEducacional(1);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(removerResumoEducacionalPortIn).remover(1);
    }

    @Test
    void deveAtualizarResumoEducacionalComSucesso()
            throws ResumoEducacionalNaoEncontradoException, IdResumoEducacionalObrigatorioException {

        final ResumoEducacionalDTO resumoEducacionalAtualizado =
                ResumoEducacionalStub.getResumoEducacionalCompleta();

        when(atualizarResumoEducacionalPortIn.atualizar(any(ResumoEducacionalDTO.class)))
                .thenReturn(resumoEducacionalAtualizado);

        final ResponseEntity<?> resposta =
                resumoEducacionalAdapter.atualizaResumoEducacional(resumoEducacionalAtualizado);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(200), resposta.getStatusCode());
        assertEquals(resumoEducacionalAtualizado, resposta.getBody());

        verify(atualizarResumoEducacionalPortIn).atualizar(resumoEducacionalAtualizado);
    }

    @Test
    void deveLancarExcecaoQuandoNaoEncontrarResumoEducacionalParaAtualizar()
            throws ResumoEducacionalNaoEncontradoException, IdResumoEducacionalObrigatorioException {

        final ResumoEducacionalDTO resumoEducacionalDTO =
                ResumoEducacionalStub.getResumoEducacionalCompleta();

        when(atualizarResumoEducacionalPortIn.atualizar(any(ResumoEducacionalDTO.class)))
                .thenThrow(ResumoEducacionalNaoEncontradoException.class);

        final ResponseEntity<?> erro =
                resumoEducacionalAdapter.atualizaResumoEducacional(resumoEducacionalDTO);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(atualizarResumoEducacionalPortIn).atualizar(resumoEducacionalDTO);
    }

    @Test
    void deveLancarExcecaoQuandoIdResumoEducacionalForObrigatorioNaAtualizacao()
            throws ResumoEducacionalNaoEncontradoException, IdResumoEducacionalObrigatorioException {

        final ResumoEducacionalDTO resumoEducacionalDTO =
                ResumoEducacionalStub.getResumoEducacionalCompleta();

        when(atualizarResumoEducacionalPortIn.atualizar(any(ResumoEducacionalDTO.class)))
                .thenThrow(IdResumoEducacionalObrigatorioException.class);

        final ResponseEntity<?> erro =
                resumoEducacionalAdapter.atualizaResumoEducacional(resumoEducacionalDTO);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(atualizarResumoEducacionalPortIn).atualizar(resumoEducacionalDTO);
    }
}