package br.com.olharpedagogicoia.adapters.in;

import br.com.olharpedagogicoia.application.dto.UnidadeDto;
import br.com.olharpedagogicoia.application.exceptions.IdUnidadeObrigatorioException;
import br.com.olharpedagogicoia.application.exceptions.UnidadeNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.in.AtualizarUnidadePortIn;
import br.com.olharpedagogicoia.application.port.in.CadastrarUnidadePortIn;
import br.com.olharpedagogicoia.application.port.in.ConsultarUnidadePortIn;
import br.com.olharpedagogicoia.application.port.in.RemoverUnidadePortIn;
import br.com.olharpedagogicoia.application.stub.UnidadeStub;
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
public class UnidadeAdapterTest {

    @Mock
    private ConsultarUnidadePortIn consultarUnidadePortIn;

    @Mock
    private RemoverUnidadePortIn removerUnidadePortIn;

    @Mock
    private CadastrarUnidadePortIn cadastrarUnidadePortIn;

    @Mock
    private AtualizarUnidadePortIn atualizarUnidadePortIn;

    @InjectMocks
    private UnidadeAdapter unidadeAdapter;

    @Test
    void deveConsultarUnidadeComSucesso() throws UnidadeNaoEncontradaException {

        final UnidadeDto unidadeConsultada = UnidadeStub.getUnidadeCompleta();

        when(consultarUnidadePortIn.consultar(1)).thenReturn(unidadeConsultada);

        final ResponseEntity<?> resposta = unidadeAdapter.consultaUnidade(1);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(200), resposta.getStatusCode());
        assertEquals(unidadeConsultada, resposta.getBody());

        verify(consultarUnidadePortIn).consultar(1);
    }

    @Test
    void deveLancarExcecaoQuandoNaoEncontrarUnidadeNaConsulta() throws UnidadeNaoEncontradaException {

        when(consultarUnidadePortIn.consultar(anyInt()))
                .thenThrow(UnidadeNaoEncontradaException.class);

        final ResponseEntity<?> erro = unidadeAdapter.consultaUnidade(1);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(consultarUnidadePortIn).consultar(1);
    }

    @Test
    void deveCadastrarUnidadeComSucesso() {

        final UnidadeDto unidadeCadastrada = UnidadeStub.getUnidadeCompleta();

        when(cadastrarUnidadePortIn.cadastrar(any(UnidadeDto.class))).thenReturn(unidadeCadastrada);

        final ResponseEntity<UnidadeDto> resposta = unidadeAdapter.cadastraUnidade(unidadeCadastrada);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(201), resposta.getStatusCode());
        assertEquals(unidadeCadastrada, resposta.getBody());

        verify(cadastrarUnidadePortIn).cadastrar(unidadeCadastrada);
    }

    @Test
    void deveRemoverUnidadeComSucesso() throws UnidadeNaoEncontradaException {

        final ResponseEntity<?> resposta = unidadeAdapter.removerUnidade(1);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(202), resposta.getStatusCode());

        verify(removerUnidadePortIn).remover(1);
    }

    @Test
    void deveLancarExcecaoQuandoNaoEncontrarUnidadeParaRemover() throws UnidadeNaoEncontradaException {

        doThrow(UnidadeNaoEncontradaException.class)
                .when(removerUnidadePortIn).remover(1);

        final ResponseEntity<?> erro = unidadeAdapter.removerUnidade(1);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(removerUnidadePortIn).remover(1);
    }

    @Test
    void deveAtualizarUnidadeComSucesso() throws UnidadeNaoEncontradaException, IdUnidadeObrigatorioException {

        final UnidadeDto unidadeAtualizada = UnidadeStub.getUnidadeCompleta();

        when(atualizarUnidadePortIn.atualizar(any(UnidadeDto.class))).thenReturn(unidadeAtualizada);

        final ResponseEntity<?> resposta = unidadeAdapter.atualizaUnidade(unidadeAtualizada);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(200), resposta.getStatusCode());
        assertEquals(unidadeAtualizada, resposta.getBody());

        verify(atualizarUnidadePortIn).atualizar(unidadeAtualizada);
    }

    @Test
    void deveLancarExcecaoQuandoNaoEncontrarUnidadeParaAtualizar() throws UnidadeNaoEncontradaException, IdUnidadeObrigatorioException {

        final UnidadeDto unidadeDto = UnidadeStub.getUnidadeCompleta();

        when(atualizarUnidadePortIn.atualizar(any(UnidadeDto.class)))
                .thenThrow(UnidadeNaoEncontradaException.class);

        final ResponseEntity<?> erro = unidadeAdapter.atualizaUnidade(unidadeDto);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(atualizarUnidadePortIn).atualizar(unidadeDto);
    }

    @Test
    void deveLancarExcecaoQuandoIdUnidadeForObrigatorioNaAtualizacao() throws UnidadeNaoEncontradaException, IdUnidadeObrigatorioException {

        final UnidadeDto unidadeDto = UnidadeStub.getUnidadeCompleta();

        when(atualizarUnidadePortIn.atualizar(any(UnidadeDto.class)))
                .thenThrow(IdUnidadeObrigatorioException.class);

        final ResponseEntity<?> erro = unidadeAdapter.atualizaUnidade(unidadeDto);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(atualizarUnidadePortIn).atualizar(unidadeDto);
    }
}