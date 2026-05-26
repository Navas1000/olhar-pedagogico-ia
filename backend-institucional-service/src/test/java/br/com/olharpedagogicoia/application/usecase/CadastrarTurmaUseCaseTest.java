package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.TurmaDto;
import br.com.olharpedagogicoia.application.port.out.CadastrarTurmaPortOut;
import br.com.olharpedagogicoia.application.stub.TurmaStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CadastrarTurmaUseCaseTest {

    @Mock
    private CadastrarTurmaPortOut cadastrarTurmaPortOut;

    @InjectMocks
    private CadastrarTurmaUseCase cadastrarTurmaUseCase;

    @Test
    void deveCadastrarTurmaDto() {

        final TurmaDto turmaASerCadastrada = TurmaStub.getTurmaCadastrar();

        assertDoesNotThrow(() -> cadastrarTurmaUseCase.cadastrar(turmaASerCadastrada));

        assertNotNull(turmaASerCadastrada.getDataCriacao());
        assertNotNull(turmaASerCadastrada.getDataModificacao());

        verify(cadastrarTurmaPortOut).cadastrar(turmaASerCadastrada);
    }
}