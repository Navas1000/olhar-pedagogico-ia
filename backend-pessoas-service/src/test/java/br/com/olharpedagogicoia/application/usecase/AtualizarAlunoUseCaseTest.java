package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.AlunoDTO;
import br.com.olharpedagogicoia.application.exceptions.AlunoNaoEncontradoException;
import br.com.olharpedagogicoia.application.exceptions.IdAlunoObrigatorioException;
import br.com.olharpedagogicoia.application.port.out.AtualizarAlunoPortOut;
import br.com.olharpedagogicoia.application.port.out.ConsultarAlunoPortOut;
import br.com.olharpedagogicoia.application.stub.AlunoStub;
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
public class AtualizarAlunoUseCaseTest {

    @Mock
    private ConsultarAlunoPortOut consultarAlunoPortOut;

    @Spy
    private AtualizarAlunoPortOut atualizarAlunoPortOut;

    @InjectMocks
    private AtualizarAlunoUseCase atualizarAlunoUseCase;

    @Test
    void deveAtualizarAlunoDto() throws AlunoNaoEncontradoException, IdAlunoObrigatorioException {

        final AlunoDTO alunoConsultado = AlunoStub.getAlunoCompleta();
        when(consultarAlunoPortOut.consultar(anyInt())).thenReturn(alunoConsultado);

        final AlunoDTO alunoAtualizado = AlunoStub.getAlunoAlterada();
        when(atualizarAlunoPortOut.atualizar(any(AlunoDTO.class))).thenReturn(alunoAtualizado);

        final AlunoDTO alunoASerAtualizado = AlunoStub.getAlunoCompleta();

        final AlunoDTO resultadoDaAtualizacao = atualizarAlunoUseCase.atualizar(alunoASerAtualizado);

        final ArgumentCaptor<AlunoDTO> capturador = ArgumentCaptor.forClass(AlunoDTO.class);
        verify(atualizarAlunoPortOut).atualizar(capturador.capture());

        final AlunoDTO alunoRecebidoNoAtualizar = capturador.getValue();

        assertEquals(
                alunoConsultado.getDataCriacao(),
                alunoRecebidoNoAtualizar.getDataCriacao()
        );

        assertNotEquals(
                alunoConsultado.getDataModificacao(),
                alunoRecebidoNoAtualizar.getDataModificacao()
        );

        verify(consultarAlunoPortOut).consultar(anyInt());
        verify(atualizarAlunoPortOut).atualizar(any(AlunoDTO.class));

        assertNotNull(resultadoDaAtualizacao);
    }

    @Test
    void deveLancarAExcecaoIdAlunoObrigatorioQuandoIdAlunoForNulo() {

        final AlunoDTO aluno = new AlunoDTO();

        assertThrows(
                IdAlunoObrigatorioException.class,
                () -> atualizarAlunoUseCase.atualizar(aluno)
        );
    }

    @Test
    void deveLancarAExcecaoAlunoNaoEncontradoQuandoOAlunoNaoExistirNaBase()
            throws AlunoNaoEncontradoException {

        when(consultarAlunoPortOut.consultar(anyInt()))
                .thenThrow(AlunoNaoEncontradoException.class);

        final AlunoDTO aluno = AlunoStub.getAlunoCompleta();

        assertThrows(
                AlunoNaoEncontradoException.class,
                () -> atualizarAlunoUseCase.atualizar(aluno)
        );
    }
}