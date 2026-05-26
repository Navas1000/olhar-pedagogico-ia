package br.com.olharpedagogicoia.adapters.out.turma;

import br.com.olharpedagogicoia.adapters.out.turma.entity.TurmaEntity;
import br.com.olharpedagogicoia.adapters.out.turma.mapper.TurmaMapper;
import br.com.olharpedagogicoia.adapters.out.turma.repository.TurmaRepository;
import br.com.olharpedagogicoia.application.dto.TurmaDto;
import br.com.olharpedagogicoia.application.stub.TurmaStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AtualizarTurmaRepositoryAdapterTest {

    @Mock
    private TurmaRepository turmaRepository;

    @Mock
    private TurmaMapper turmaMapper;

    @InjectMocks
    private AtualizarTurmaRepositoryAdapter atualizarTurmaRepositoryAdapter;

    @Test
    void deveAtualizarTurmaComSucesso() {

        final TurmaDto turmaDto = TurmaStub.getTurmaCompleta();
        final TurmaEntity turmaEntity = new TurmaEntity();

        when(turmaMapper.deTurmaDTOParaTurmaEntity(turmaDto)).thenReturn(turmaEntity);
        when(turmaRepository.save(turmaEntity)).thenReturn(turmaEntity);
        when(turmaMapper.deTurmaEntityParaTurmaDTO(turmaEntity)).thenReturn(turmaDto);

        final TurmaDto resposta = atualizarTurmaRepositoryAdapter.atualizar(turmaDto);

        assertNotNull(resposta);
        assertEquals(turmaDto, resposta);

        verify(turmaMapper).deTurmaDTOParaTurmaEntity(turmaDto);
        verify(turmaRepository).save(turmaEntity);
        verify(turmaMapper).deTurmaEntityParaTurmaDTO(turmaEntity);
    }
}