package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.UnidadeDto;
import br.com.olharpedagogicoia.application.exceptions.IdUnidadeObrigatorioException;
import br.com.olharpedagogicoia.application.exceptions.UnidadeNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.out.AtualizarUnidadePortOut;
import br.com.olharpedagogicoia.application.port.out.ConsultarUnidadePortOut;
import br.com.olharpedagogicoia.application.stub.UnidadeStub;
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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AtualizarUnidadeUseCaseTest {

    @Mock
    private ConsultarUnidadePortOut consultarUnidadePortOut;

    @Spy
    private AtualizarUnidadePortOut atualizarUnidadePortOut;

    @InjectMocks
    private AtualizarUnidadeUseCase atualizarUnidadeUseCase;

    @Test
    void deveAtualizarUnidadeDto() throws UnidadeNaoEncontradaException, IdUnidadeObrigatorioException {

        final UnidadeDto unidadeConsultada = UnidadeStub.getUnidadeCompleta();
        when(consultarUnidadePortOut.consultar(anyInt())).thenReturn(unidadeConsultada);

        final UnidadeDto unidadeAtualizada = UnidadeStub.getUnidadeAlterada();
        when(atualizarUnidadePortOut.atualizar(any(UnidadeDto.class))).thenReturn(unidadeAtualizada);

        final UnidadeDto unidadeASerAtualizada = UnidadeStub.getUnidadeCompleta();
        final UnidadeDto resultadoDaAtualizacao = atualizarUnidadeUseCase.atualizar(unidadeASerAtualizada);

        final ArgumentCaptor<UnidadeDto> capturador = ArgumentCaptor.forClass(UnidadeDto.class);
        verify(atualizarUnidadePortOut).atualizar(capturador.capture());

        final UnidadeDto unidadeRecebidaNoAtualizar = capturador.getValue();

        assertEquals(
                unidadeConsultada.getDataCriacao(),
                unidadeRecebidaNoAtualizar.getDataCriacao()
        );

        assertNotEquals(
                unidadeConsultada.getDataModificacao(),
                unidadeRecebidaNoAtualizar.getDataModificacao()
        );

        verify(consultarUnidadePortOut).consultar(anyInt());
        verify(atualizarUnidadePortOut).atualizar(any(UnidadeDto.class));

        assertNotNull(resultadoDaAtualizacao);
    }

    @Test
    void deveLancarAExcecaoIdUnidadeObrigatorioQuandoIdUnidadeForNulo() {
        final UnidadeDto unidade = new UnidadeDto();

        assertThrows(
                IdUnidadeObrigatorioException.class,
                () -> atualizarUnidadeUseCase.atualizar(unidade)
        );
    }

    @Test
    void deveLancarAExcecaoUnidadeNaoEncontradaQuandoAUnidadeNaoExistirNaBase()
            throws UnidadeNaoEncontradaException, IdUnidadeObrigatorioException {

        when(consultarUnidadePortOut.consultar(anyInt()))
                .thenThrow(UnidadeNaoEncontradaException.class);

        final UnidadeDto unidade = UnidadeStub.getUnidadeCompleta();

        assertThrows(
                UnidadeNaoEncontradaException.class,
                () -> atualizarUnidadeUseCase.atualizar(unidade)
        );
    }
}