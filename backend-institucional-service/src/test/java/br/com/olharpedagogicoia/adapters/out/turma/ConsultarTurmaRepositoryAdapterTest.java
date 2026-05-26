package br.com.olharpedagogicoia.adapters.out.turma;

import br.com.olharpedagogicoia.adapters.out.turma.entity.TurmaEntity;
import br.com.olharpedagogicoia.adapters.out.turma.mapper.TurmaMapper;
import br.com.olharpedagogicoia.adapters.out.turma.repository.TurmaRepository;
import br.com.olharpedagogicoia.application.dto.TurmaDto;
import br.com.olharpedagogicoia.application.exceptions.TurmaNaoEncontradaException;
import br.com.olharpedagogicoia.application.stub.TurmaStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ConsultarTurmaRepositoryAdapterTest {

    @Mock
    private TurmaRepository turmaRepository;

    @Mock
    private TurmaMapper turmaMapper;

    @InjectMocks
    private ConsultarTurmaRepositoryAdapter consultarTurmaRepositoryAdapter;

    @Test
    void deveConsultarTurmaComSucesso() throws TurmaNaoEncontradaException {

        final Integer idTurma = 1;
        final TurmaDto turmaDto = TurmaStub.getTurmaCompleta();
        final TurmaEntity turmaEntity = new TurmaEntity();

        when(turmaRepository.findById(idTurma)).thenReturn(Optional.of(turmaEntity));
        when(turmaMapper.deTurmaEntityParaTurmaDTO(turmaEntity)).thenReturn(turmaDto);

        final TurmaDto resposta = consultarTurmaRepositoryAdapter.consultar(idTurma);

        assertNotNull(resposta);
        assertEquals(turmaDto, resposta);

        verify(turmaRepository).findById(idTurma);
        verify(turmaMapper).deTurmaEntityParaTurmaDTO(turmaEntity);
    }

    @Test
    void deveLancarExcecaoQuandoTurmaNaoForEncontrada() {

        final Integer idTurma = 1;

        when(turmaRepository.findById(idTurma)).thenReturn(Optional.empty());

        assertThrows(TurmaNaoEncontradaException.class,
                () -> consultarTurmaRepositoryAdapter.consultar(idTurma));

        verify(turmaRepository).findById(idTurma);
        verifyNoInteractions(turmaMapper);
    }
}