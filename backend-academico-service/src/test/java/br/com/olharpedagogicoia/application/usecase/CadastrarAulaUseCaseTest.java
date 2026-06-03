package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.AulaDTO;
import br.com.olharpedagogicoia.application.port.out.CadastrarAulaPortOut;
import br.com.olharpedagogicoia.application.stub.AulaStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CadastrarAulaUseCaseTest {

    @Mock
    private CadastrarAulaPortOut cadastrarAulaPortOut;

    @InjectMocks
    private CadastrarAulaUseCase cadastrarAulaUseCase;

    @Test
    void deveCadastrarAulaDto() {

        final AulaDTO aulaASerCadastrada = AulaStub.getAulaCadastrar();

        assertDoesNotThrow(() ->
                cadastrarAulaUseCase.cadastrar(aulaASerCadastrada)
        );

        assertNotNull(aulaASerCadastrada.getDataCriacao());

        verify(cadastrarAulaPortOut).cadastrar(aulaASerCadastrada);
    }
}