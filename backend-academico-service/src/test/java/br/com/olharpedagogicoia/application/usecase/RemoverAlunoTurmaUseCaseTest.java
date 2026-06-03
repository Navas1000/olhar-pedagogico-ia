package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.exceptions.AlunoTurmaNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.out.RemoverAlunoTurmaPortOut;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class RemoverAlunoTurmaUseCaseTest {

    @Mock
    private RemoverAlunoTurmaPortOut removerAlunoTurmaPortOut;

    @InjectMocks
    private RemoverAlunoTurmaUseCase removerAlunoTurmaUseCase;

    @Test
    void deveRemoverAlunoTurma() throws AlunoTurmaNaoEncontradaException {

        assertDoesNotThrow(() -> removerAlunoTurmaUseCase.remover(1));

        verify(removerAlunoTurmaPortOut).remover(anyInt());
    }
}