package br.com.olharpedagogicoia.adapters.in;

import br.com.olharpedagogicoia.application.dto.DiarioEducacionalDTO;
import br.com.olharpedagogicoia.application.exceptions.DiarioEducacionalNaoEncontradoException;
import br.com.olharpedagogicoia.application.exceptions.IdDiarioEducacionalObrigatorioException;
import br.com.olharpedagogicoia.application.port.in.AtualizarDiarioEducacionalPortIn;
import br.com.olharpedagogicoia.application.port.in.CadastrarDiarioEducacionalPortIn;
import br.com.olharpedagogicoia.application.port.in.ConsultarDiarioEducacionalPortIn;
import br.com.olharpedagogicoia.application.port.in.RemoverDiarioEducacionalPortIn;
import br.com.olharpedagogicoia.application.stub.DiarioEducacionalStub;
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
public class DiarioEducacionalAdapterTest {

    @Mock
    private ConsultarDiarioEducacionalPortIn consultarDiarioEducacionalPortIn;

    @Mock
    private CadastrarDiarioEducacionalPortIn cadastrarDiarioEducacionalPortIn;

    @Mock
    private RemoverDiarioEducacionalPortIn removerDiarioEducacionalPortIn;

    @Mock
    private AtualizarDiarioEducacionalPortIn atualizarDiarioEducacionalPortIn;

    @InjectMocks
    private DiarioEducacionalAdapter diarioEducacionalAdapter;

    @Test
    void deveConsultarDiarioEducacionalComSucesso() throws DiarioEducacionalNaoEncontradoException {

        final DiarioEducacionalDTO diarioEducacionalConsultado =
                DiarioEducacionalStub.getDiarioEducacionalCompleta();

        when(consultarDiarioEducacionalPortIn.consultar(1))
                .thenReturn(diarioEducacionalConsultado);

        final ResponseEntity<?> resposta =
                diarioEducacionalAdapter.consultaDiarioEducacional(1);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(200), resposta.getStatusCode());
        assertEquals(diarioEducacionalConsultado, resposta.getBody());

        verify(consultarDiarioEducacionalPortIn).consultar(1);
    }

    @Test
    void deveLancarExcecaoQuandoNaoEncontrarDiarioEducacionalNaConsulta()
            throws DiarioEducacionalNaoEncontradoException {

        when(consultarDiarioEducacionalPortIn.consultar(anyInt()))
                .thenThrow(DiarioEducacionalNaoEncontradoException.class);

        final ResponseEntity<?> erro =
                diarioEducacionalAdapter.consultaDiarioEducacional(1);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(consultarDiarioEducacionalPortIn).consultar(1);
    }

    @Test
    void deveCadastrarDiarioEducacionalComSucesso() {

        final DiarioEducacionalDTO diarioEducacionalCadastrado =
                DiarioEducacionalStub.getDiarioEducacionalCompleta();

        when(cadastrarDiarioEducacionalPortIn.cadastrar(any(DiarioEducacionalDTO.class)))
                .thenReturn(diarioEducacionalCadastrado);

        final ResponseEntity<DiarioEducacionalDTO> resposta =
                diarioEducacionalAdapter.cadastraDiarioEducacional(diarioEducacionalCadastrado);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(201), resposta.getStatusCode());
        assertEquals(diarioEducacionalCadastrado, resposta.getBody());

        verify(cadastrarDiarioEducacionalPortIn).cadastrar(diarioEducacionalCadastrado);
    }

    @Test
    void deveRemoverDiarioEducacionalComSucesso() throws DiarioEducacionalNaoEncontradoException {

        final ResponseEntity<?> resposta =
                diarioEducacionalAdapter.removerDiarioEducacional(1);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(202), resposta.getStatusCode());

        verify(removerDiarioEducacionalPortIn).remover(1);
    }

    @Test
    void deveLancarExcecaoQuandoNaoEncontrarDiarioEducacionalParaRemover()
            throws DiarioEducacionalNaoEncontradoException {

        doThrow(DiarioEducacionalNaoEncontradoException.class)
                .when(removerDiarioEducacionalPortIn).remover(1);

        final ResponseEntity<?> erro =
                diarioEducacionalAdapter.removerDiarioEducacional(1);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(removerDiarioEducacionalPortIn).remover(1);
    }

    @Test
    void deveAtualizarDiarioEducacionalComSucesso()
            throws DiarioEducacionalNaoEncontradoException, IdDiarioEducacionalObrigatorioException {

        final DiarioEducacionalDTO diarioEducacionalAtualizado =
                DiarioEducacionalStub.getDiarioEducacionalCompleta();

        when(atualizarDiarioEducacionalPortIn.atualizar(any(DiarioEducacionalDTO.class)))
                .thenReturn(diarioEducacionalAtualizado);

        final ResponseEntity<?> resposta =
                diarioEducacionalAdapter.atualizaDiarioEducacional(diarioEducacionalAtualizado);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(200), resposta.getStatusCode());
        assertEquals(diarioEducacionalAtualizado, resposta.getBody());

        verify(atualizarDiarioEducacionalPortIn).atualizar(diarioEducacionalAtualizado);
    }

    @Test
    void deveLancarExcecaoQuandoNaoEncontrarDiarioEducacionalParaAtualizar()
            throws DiarioEducacionalNaoEncontradoException, IdDiarioEducacionalObrigatorioException {

        final DiarioEducacionalDTO diarioEducacionalDTO =
                DiarioEducacionalStub.getDiarioEducacionalCompleta();

        when(atualizarDiarioEducacionalPortIn.atualizar(any(DiarioEducacionalDTO.class)))
                .thenThrow(DiarioEducacionalNaoEncontradoException.class);

        final ResponseEntity<?> erro =
                diarioEducacionalAdapter.atualizaDiarioEducacional(diarioEducacionalDTO);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(atualizarDiarioEducacionalPortIn).atualizar(diarioEducacionalDTO);
    }

    @Test
    void deveLancarExcecaoQuandoIdDiarioEducacionalForObrigatorioNaAtualizacao()
            throws DiarioEducacionalNaoEncontradoException, IdDiarioEducacionalObrigatorioException {

        final DiarioEducacionalDTO diarioEducacionalDTO =
                DiarioEducacionalStub.getDiarioEducacionalCompleta();

        when(atualizarDiarioEducacionalPortIn.atualizar(any(DiarioEducacionalDTO.class)))
                .thenThrow(IdDiarioEducacionalObrigatorioException.class);

        final ResponseEntity<?> erro =
                diarioEducacionalAdapter.atualizaDiarioEducacional(diarioEducacionalDTO);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(atualizarDiarioEducacionalPortIn).atualizar(diarioEducacionalDTO);
    }
}