package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.exceptions.ProfessorTurmaNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.out.RemoverProfessorTurmaPortOut;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class RemoverProfessorTurmaUseCaseTest {

    @Mock
    private RemoverProfessorTurmaPortOut removerProfessorTurmaPortOut;

    @InjectMocks
    private RemoverProfessorTurmaUseCase removerProfessorTurmaUseCase;

    @Test
    void deveRemoverProfessorTurma() throws ProfessorTurmaNaoEncontradaException {

        assertDoesNotThrow(() -> removerProfessorTurmaUseCase.remover(1));

        verify(removerProfessorTurmaPortOut).remover(anyInt());
    }
}