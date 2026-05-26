package br.com.olharpedagogicoia.adapters.in;

import br.com.olharpedagogicoia.application.dto.EmpresaDto;
import br.com.olharpedagogicoia.application.exceptions.EmpresaNaoEncontradaException;
import br.com.olharpedagogicoia.application.exceptions.IdEmpresaObrigatorioException;
import br.com.olharpedagogicoia.application.port.in.AtualizarEmpresaPortIn;
import br.com.olharpedagogicoia.application.port.in.CadastrarEmpresaPortIn;
import br.com.olharpedagogicoia.application.port.in.ConsultarEmpresaPortIn;
import br.com.olharpedagogicoia.application.port.in.RemoverEmpresaPortIn;
import br.com.olharpedagogicoia.application.stub.EmpresaStub;
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
public class EmpresaAdapterTest {

    @Mock
    private ConsultarEmpresaPortIn consultarEmpresaPortIn;

    @Mock
    private CadastrarEmpresaPortIn cadastrarEmpresaPortIn;

    @Mock
    private RemoverEmpresaPortIn removerEmpresaPortIn;

    @Mock
    private AtualizarEmpresaPortIn atualizarEmpresaPortIn;

    @InjectMocks
    private EmpresaAdapter empresaAdapter;

    @Test
    void deveConsultarEmpresaComSucesso() throws EmpresaNaoEncontradaException {

        final EmpresaDto empresaConsultada = EmpresaStub.getEmpresaCompleta();

        when(consultarEmpresaPortIn.consultar(1)).thenReturn(empresaConsultada);

        final ResponseEntity<?> resposta = empresaAdapter.consultaEmpresa(1);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(200), resposta.getStatusCode());
        assertEquals(empresaConsultada, resposta.getBody());

        verify(consultarEmpresaPortIn).consultar(1);
    }

    @Test
    void deveLevantarExcecaoQuandoNaoEncontrarOId() throws EmpresaNaoEncontradaException {

        when(consultarEmpresaPortIn.consultar(anyInt()))
                .thenThrow(EmpresaNaoEncontradaException.class);

        final ResponseEntity<?> erro = empresaAdapter.consultaEmpresa(1);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(consultarEmpresaPortIn).consultar(1);
    }

    @Test
    void deveCadastrarAEmpresa() {

        final EmpresaDto empresaCadastrada = EmpresaStub.getEmpresaCompleta();

        when(cadastrarEmpresaPortIn.cadastrar(any(EmpresaDto.class))).thenReturn(empresaCadastrada);

        final ResponseEntity<EmpresaDto> resposta = empresaAdapter.cadastraEmpresa(empresaCadastrada);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(201), resposta.getStatusCode());
        assertEquals(empresaCadastrada, resposta.getBody());

        verify(cadastrarEmpresaPortIn).cadastrar(empresaCadastrada);
    }

    @Test
    void deveRemoverAEmpresa() throws EmpresaNaoEncontradaException {

        final ResponseEntity<?> resposta = empresaAdapter.removerEmpresa(1);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(202), resposta.getStatusCode());

        verify(removerEmpresaPortIn).remover(1);
    }

    @Test
    void deveLancarExcecaoQuandoNaoEncontrarEmpresaParaRemover() throws EmpresaNaoEncontradaException {

        doThrow(EmpresaNaoEncontradaException.class)
                .when(removerEmpresaPortIn).remover(1);

        final ResponseEntity<?> erro = empresaAdapter.removerEmpresa(1);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(removerEmpresaPortIn).remover(1);
    }

    @Test
    void deveAtualizarEmpresa() throws EmpresaNaoEncontradaException, IdEmpresaObrigatorioException {

        final EmpresaDto empresaAtualizada = EmpresaStub.getEmpresaCompleta();

        when(atualizarEmpresaPortIn.atualizar(any(EmpresaDto.class))).thenReturn(empresaAtualizada);

        final ResponseEntity<?> resposta = empresaAdapter.atualizaEmpresa(empresaAtualizada);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(200), resposta.getStatusCode());
        assertEquals(empresaAtualizada, resposta.getBody());

        verify(atualizarEmpresaPortIn).atualizar(empresaAtualizada);
    }

    @Test
    void deveLancarExcecaoQuandoNaoEncontrarAEmpresaParaAtualizar() throws EmpresaNaoEncontradaException, IdEmpresaObrigatorioException {

        final EmpresaDto empresaDto = EmpresaStub.getEmpresaCompleta();

        when(atualizarEmpresaPortIn.atualizar(any(EmpresaDto.class)))
                .thenThrow(EmpresaNaoEncontradaException.class);

        final ResponseEntity<?> erro = empresaAdapter.atualizaEmpresa(empresaDto);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(atualizarEmpresaPortIn).atualizar(empresaDto);
    }

    @Test
    void deveLancarExcecaoQuandoNaoEncontrarOIdDaEmpresaParaAtualizar() throws EmpresaNaoEncontradaException, IdEmpresaObrigatorioException {

        final EmpresaDto empresaDto = EmpresaStub.getEmpresaCompleta();

        when(atualizarEmpresaPortIn.atualizar(any(EmpresaDto.class)))
                .thenThrow(IdEmpresaObrigatorioException.class);

        final ResponseEntity<?> erro = empresaAdapter.atualizaEmpresa(empresaDto);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(atualizarEmpresaPortIn).atualizar(empresaDto);
    }
}