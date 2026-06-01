package br.com.olharpedagogicoia.adapters.in;

import br.com.olharpedagogicoia.application.dto.FuncionarioDTO;
import br.com.olharpedagogicoia.application.exceptions.FuncionarioNaoEncontradoException;
import br.com.olharpedagogicoia.application.exceptions.IdFuncionarioObrigatorioException;
import br.com.olharpedagogicoia.application.port.in.AtualizarFuncionarioPortIn;
import br.com.olharpedagogicoia.application.port.in.CadastrarFuncionarioPortIn;
import br.com.olharpedagogicoia.application.port.in.ConsultarFuncionarioPortIn;
import br.com.olharpedagogicoia.application.port.in.RemoverFuncionarioPortIn;
import br.com.olharpedagogicoia.application.stub.FuncionarioStub;
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
public class FuncionarioAdapterTest {

    @Mock
    private ConsultarFuncionarioPortIn consultarFuncionarioPortIn;

    @Mock
    private RemoverFuncionarioPortIn removerFuncionarioPortIn;

    @Mock
    private CadastrarFuncionarioPortIn cadastrarFuncionarioPortIn;

    @Mock
    private AtualizarFuncionarioPortIn atualizarFuncionarioPortIn;

    @InjectMocks
    private FuncionarioAdapter funcionarioAdapter;

    @Test
    void deveConsultarFuncionarioComSucesso() throws FuncionarioNaoEncontradoException {

        final FuncionarioDTO funcionarioConsultado = FuncionarioStub.getFuncionarioCompleta();

        when(consultarFuncionarioPortIn.consultar(1)).thenReturn(funcionarioConsultado);

        final ResponseEntity<?> resposta = funcionarioAdapter.consultaFuncionario(1);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(200), resposta.getStatusCode());
        assertEquals(funcionarioConsultado, resposta.getBody());

        verify(consultarFuncionarioPortIn).consultar(1);
    }

    @Test
    void deveLancarExcecaoQuandoNaoEncontrarFuncionarioNaConsulta() throws FuncionarioNaoEncontradoException {

        when(consultarFuncionarioPortIn.consultar(anyInt()))
                .thenThrow(FuncionarioNaoEncontradoException.class);

        final ResponseEntity<?> erro = funcionarioAdapter.consultaFuncionario(1);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(consultarFuncionarioPortIn).consultar(1);
    }

    @Test
    void deveCadastrarFuncionarioComSucesso() {

        final FuncionarioDTO funcionarioCadastrado = FuncionarioStub.getFuncionarioCompleta();

        when(cadastrarFuncionarioPortIn.cadastrar(any(FuncionarioDTO.class))).thenReturn(funcionarioCadastrado);

        final ResponseEntity<FuncionarioDTO> resposta = funcionarioAdapter.cadastraFuncionario(funcionarioCadastrado);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(201), resposta.getStatusCode());
        assertEquals(funcionarioCadastrado, resposta.getBody());

        verify(cadastrarFuncionarioPortIn).cadastrar(funcionarioCadastrado);
    }

    @Test
    void deveRemoverFuncionarioComSucesso() throws FuncionarioNaoEncontradoException {

        final ResponseEntity<?> resposta = funcionarioAdapter.removerFuncionario(1);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(202), resposta.getStatusCode());

        verify(removerFuncionarioPortIn).remover(1);
    }

    @Test
    void deveLancarExcecaoQuandoNaoEncontrarFuncionarioParaRemover() throws FuncionarioNaoEncontradoException {

        doThrow(FuncionarioNaoEncontradoException.class)
                .when(removerFuncionarioPortIn).remover(1);

        final ResponseEntity<?> erro = funcionarioAdapter.removerFuncionario(1);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(removerFuncionarioPortIn).remover(1);
    }

    @Test
    void deveAtualizarFuncionarioComSucesso() throws FuncionarioNaoEncontradoException, IdFuncionarioObrigatorioException {

        final FuncionarioDTO funcionarioAtualizado = FuncionarioStub.getFuncionarioCompleta();

        when(atualizarFuncionarioPortIn.atualizar(any(FuncionarioDTO.class))).thenReturn(funcionarioAtualizado);

        final ResponseEntity<?> resposta = funcionarioAdapter.atualizaFuncionario(funcionarioAtualizado);

        assertNotNull(resposta);
        assertEquals(HttpStatusCode.valueOf(200), resposta.getStatusCode());
        assertEquals(funcionarioAtualizado, resposta.getBody());

        verify(atualizarFuncionarioPortIn).atualizar(funcionarioAtualizado);
    }

    @Test
    void deveLancarExcecaoQuandoNaoEncontrarFuncionarioParaAtualizar() throws FuncionarioNaoEncontradoException, IdFuncionarioObrigatorioException {

        final FuncionarioDTO funcionarioDTO = FuncionarioStub.getFuncionarioCompleta();

        when(atualizarFuncionarioPortIn.atualizar(any(FuncionarioDTO.class)))
                .thenThrow(FuncionarioNaoEncontradoException.class);

        final ResponseEntity<?> erro = funcionarioAdapter.atualizaFuncionario(funcionarioDTO);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(atualizarFuncionarioPortIn).atualizar(funcionarioDTO);
    }

    @Test
    void deveLancarExcecaoQuandoIdFuncionarioForObrigatorioNaAtualizacao() throws FuncionarioNaoEncontradoException, IdFuncionarioObrigatorioException {

        final FuncionarioDTO funcionarioDTO = FuncionarioStub.getFuncionarioCompleta();

        when(atualizarFuncionarioPortIn.atualizar(any(FuncionarioDTO.class)))
                .thenThrow(IdFuncionarioObrigatorioException.class);

        final ResponseEntity<?> erro = funcionarioAdapter.atualizaFuncionario(funcionarioDTO);

        assertNotNull(erro);
        assertEquals(HttpStatusCode.valueOf(404), erro.getStatusCode());

        verify(atualizarFuncionarioPortIn).atualizar(funcionarioDTO);
    }
}