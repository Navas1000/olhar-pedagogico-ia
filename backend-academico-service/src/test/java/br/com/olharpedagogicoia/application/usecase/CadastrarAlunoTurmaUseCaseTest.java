package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.AlunoTurmaDTO;
import br.com.olharpedagogicoia.application.port.out.CadastrarAlunoTurmaPortOut;
import br.com.olharpedagogicoia.application.stub.AlunoTurmaStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CadastrarAlunoTurmaUseCaseTest {

    @Mock
    private CadastrarAlunoTurmaPortOut cadastrarAlunoTurmaPortOut;

    @InjectMocks
    private CadastrarAlunoTurmaUseCase cadastrarAlunoTurmaUseCase;

    @Test
    void deveCadastrarAlunoTurmaDto() {

        final AlunoTurmaDTO alunoTurmaASerCadastrado = AlunoTurmaStub.getAlunoTurmaCadastrar();

        assertDoesNotThrow(() ->
                cadastrarAlunoTurmaUseCase.cadastrar(alunoTurmaASerCadastrado)
        );

        assertNotNull(alunoTurmaASerCadastrado.getDataCriacao());

        verify(cadastrarAlunoTurmaPortOut).cadastrar(alunoTurmaASerCadastrado);
    }
}