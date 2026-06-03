package br.com.olharpedagogicoia.adapters.out.alunoTurma;

import br.com.olharpedagogicoia.adapters.out.alunoTurma.entity.AlunoTurmaEntity;
import br.com.olharpedagogicoia.adapters.out.alunoTurma.mapper.AlunoTurmaMapper;
import br.com.olharpedagogicoia.adapters.out.alunoTurma.repository.AlunoTurmaRepository;
import br.com.olharpedagogicoia.application.dto.AlunoTurmaDTO;
import br.com.olharpedagogicoia.application.exceptions.AlunoTurmaNaoEncontradaException;
import br.com.olharpedagogicoia.application.stub.AlunoTurmaStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ConsultarAlunoTurmaRepositoryAdapterTest {

    @Mock
    private AlunoTurmaRepository alunoTurmaRepository;

    @Mock
    private AlunoTurmaMapper alunoTurmaMapper;

    @InjectMocks
    private ConsultarAlunoTurmaRepositoryAdapter consultarAlunoTurmaRepositoryAdapter;

    @Test
    void deveConsultarAlunoTurmaComSucesso() throws AlunoTurmaNaoEncontradaException {

        final Integer idMatricula = 1;
        final AlunoTurmaDTO alunoTurmaDTO = AlunoTurmaStub.getAlunoTurmaCompleta();
        final AlunoTurmaEntity alunoTurmaEntity = new AlunoTurmaEntity();

        when(alunoTurmaRepository.findById(idMatricula)).thenReturn(Optional.of(alunoTurmaEntity));
        when(alunoTurmaMapper.deAlunoTurmaEntityParaAlunoTurmaDTO(alunoTurmaEntity)).thenReturn(alunoTurmaDTO);

        final AlunoTurmaDTO resposta = consultarAlunoTurmaRepositoryAdapter.consultar(idMatricula);

        assertNotNull(resposta);
        assertEquals(alunoTurmaDTO, resposta);

        verify(alunoTurmaRepository).findById(idMatricula);
        verify(alunoTurmaMapper).deAlunoTurmaEntityParaAlunoTurmaDTO(alunoTurmaEntity);
    }

    @Test
    void deveLancarExcecaoQuandoAlunoTurmaNaoForEncontrada() {

        final Integer idMatricula = 1;

        when(alunoTurmaRepository.findById(idMatricula)).thenReturn(Optional.empty());

        assertThrows(
                AlunoTurmaNaoEncontradaException.class,
                () -> consultarAlunoTurmaRepositoryAdapter.consultar(idMatricula)
        );

        verify(alunoTurmaRepository).findById(idMatricula);
        verifyNoInteractions(alunoTurmaMapper);
    }
}