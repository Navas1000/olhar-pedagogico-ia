package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.exceptions.AlunoNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.out.RemoverAlunoPortOut;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class RemoverAlunoUseCaseTest {

    @Mock
    private RemoverAlunoPortOut removerAlunoPortOut;

    @InjectMocks
    private RemoverAlunoUseCase removerAlunoUseCase;

    @Test
    void deveRemoverAluno() throws AlunoNaoEncontradoException {

        assertDoesNotThrow(() -> removerAlunoUseCase.remover(1));

        verify(removerAlunoPortOut).remover(anyInt());
    }
}