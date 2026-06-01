package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.AlunoDTO;
import br.com.olharpedagogicoia.application.port.out.CadastrarAlunoPortOut;
import br.com.olharpedagogicoia.application.stub.AlunoStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CadastrarAlunoUseCaseTest {

    @Mock
    private CadastrarAlunoPortOut cadastrarAlunoPortOut;

    @InjectMocks
    private CadastrarAlunoUseCase cadastrarAlunoUseCase;

    @Test
    void deveCadastrarAlunoDto() {

        final AlunoDTO alunoASerCadastrado = AlunoStub.getAlunoCadastrar();

        assertDoesNotThrow(() ->
                cadastrarAlunoUseCase.cadastrar(alunoASerCadastrado)
        );

        assertNotNull(alunoASerCadastrado.getDataCriacao());
        assertNotNull(alunoASerCadastrado.getDataModificacao());

        verify(cadastrarAlunoPortOut).cadastrar(alunoASerCadastrado);
    }
}