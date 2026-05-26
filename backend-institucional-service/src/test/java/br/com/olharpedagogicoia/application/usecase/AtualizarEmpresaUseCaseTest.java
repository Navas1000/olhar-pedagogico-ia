package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.EmpresaDto;
import br.com.olharpedagogicoia.application.exceptions.EmpresaNaoEncontradaException;
import br.com.olharpedagogicoia.application.exceptions.IdEmpresaObrigatorioException;
import br.com.olharpedagogicoia.application.port.out.AtualizarEmpresaPortOut;
import br.com.olharpedagogicoia.application.port.out.ConsultarEmpresaPortOut;
import br.com.olharpedagogicoia.application.stub.EmpresaStub;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AtualizarEmpresaUseCaseTest {

    @Mock
    private ConsultarEmpresaPortOut consultarEmpresaPortOut;
    @Spy
    private AtualizarEmpresaPortOut atualizarEmpresaPortOut;
    @InjectMocks
    private AtualizarEmpresaUseCase atualizarEmpresaUseCase;

    @Test
    void deveAtualizarEmpresaDto() throws EmpresaNaoEncontradaException, IdEmpresaObrigatorioException {

        final EmpresaDto empresaConsultada = EmpresaStub.getEmpresaCompleta();
        when(consultarEmpresaPortOut.consultar(anyInt())).thenReturn(empresaConsultada);

        final EmpresaDto empresaAtualizada = EmpresaStub.getEmpresaAlterada();
        when(atualizarEmpresaPortOut.atualizar(any(EmpresaDto.class))).thenReturn(empresaAtualizada);

        final EmpresaDto empresaASerAtualizada = EmpresaStub.getEmpresaCompleta();
        final EmpresaDto resultadoDaAtualizacao = atualizarEmpresaUseCase.atualizar(empresaASerAtualizada);

        final ArgumentCaptor<EmpresaDto> capturador = ArgumentCaptor.forClass(EmpresaDto.class);
        verify(atualizarEmpresaPortOut).atualizar(capturador.capture());
        final EmpresaDto empresaRecebidaNoAtualizar = capturador.getValue();
        assertEquals(empresaConsultada.getDataCriacao(), empresaRecebidaNoAtualizar.getDataCriacao());
        assertNotEquals(empresaConsultada.getDataModificacao(), empresaRecebidaNoAtualizar.getDataModificacao());

        verify(consultarEmpresaPortOut).consultar(anyInt());
        verify(atualizarEmpresaPortOut).atualizar(any(EmpresaDto.class));

        assertNotNull(resultadoDaAtualizacao);

    }

    @Test
    void deveLancarAExcecaoIdEmpresaObrigatorioQuandoIdEmpresaForNulo() {
        final EmpresaDto empresa = new EmpresaDto();
        assertThrows(IdEmpresaObrigatorioException.class, () -> atualizarEmpresaUseCase.atualizar(empresa));
    }

    @Test
    void deveLancarAExcecaoEmpresaNaoEncontradaQuandoAEmpresaNaoExistirNaBase() throws EmpresaNaoEncontradaException, IdEmpresaObrigatorioException {
        {
            when(consultarEmpresaPortOut.consultar(anyInt())).thenThrow(EmpresaNaoEncontradaException.class);

            final EmpresaDto empresa = EmpresaStub.getEmpresaCompleta();
            assertThrows(EmpresaNaoEncontradaException.class, () -> atualizarEmpresaUseCase.atualizar(empresa));
        }
    }
}