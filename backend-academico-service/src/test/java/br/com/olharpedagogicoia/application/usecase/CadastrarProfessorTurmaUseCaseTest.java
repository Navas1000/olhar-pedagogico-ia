package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.ProfessorTurmaDTO;
import br.com.olharpedagogicoia.application.port.out.CadastrarProfessorTurmaPortOut;
import br.com.olharpedagogicoia.application.stub.ProfessorTurmaStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CadastrarProfessorTurmaUseCaseTest {

    @Mock
    private CadastrarProfessorTurmaPortOut cadastrarProfessorTurmaPortOut;

    @InjectMocks
    private CadastrarProfessorTurmaUseCase cadastrarProfessorTurmaUseCase;

    @Test
    void deveCadastrarProfessorTurmaDto() {

        final ProfessorTurmaDTO professorTurmaASerCadastrado =
                ProfessorTurmaStub.getProfessorTurmaCadastrar();

        assertDoesNotThrow(() ->
                cadastrarProfessorTurmaUseCase.cadastrar(professorTurmaASerCadastrado)
        );

        assertNotNull(professorTurmaASerCadastrado.getDataCriacao());

        verify(cadastrarProfessorTurmaPortOut).cadastrar(professorTurmaASerCadastrado);
    }
}