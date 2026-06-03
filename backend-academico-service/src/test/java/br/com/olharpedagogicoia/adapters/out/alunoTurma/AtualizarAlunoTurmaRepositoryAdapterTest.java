package br.com.olharpedagogicoia.adapters.out.alunoTurma;

import br.com.olharpedagogicoia.adapters.out.alunoTurma.entity.AlunoTurmaEntity;
import br.com.olharpedagogicoia.adapters.out.alunoTurma.mapper.AlunoTurmaMapper;
import br.com.olharpedagogicoia.adapters.out.alunoTurma.repository.AlunoTurmaRepository;
import br.com.olharpedagogicoia.application.dto.AlunoTurmaDTO;
import br.com.olharpedagogicoia.application.stub.AlunoTurmaStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AtualizarAlunoTurmaRepositoryAdapterTest {

    @Mock
    private AlunoTurmaRepository alunoTurmaRepository;

    @Mock
    private AlunoTurmaMapper alunoTurmaMapper;

    @InjectMocks
    private AtualizarAlunoTurmaRepositoryAdapter atualizarAlunoTurmaRepositoryAdapter;

    @Test
    void deveAtualizarAlunoTurmaComSucesso() {

        final AlunoTurmaDTO alunoTurmaDTO = AlunoTurmaStub.getAlunoTurmaCompleta();
        final AlunoTurmaEntity alunoTurmaEntity = new AlunoTurmaEntity();

        when(alunoTurmaMapper.deAlunoTurmaDTOParaAlunoTurmaEntity(alunoTurmaDTO)).thenReturn(alunoTurmaEntity);
        when(alunoTurmaRepository.save(alunoTurmaEntity)).thenReturn(alunoTurmaEntity);
        when(alunoTurmaMapper.deAlunoTurmaEntityParaAlunoTurmaDTO(alunoTurmaEntity)).thenReturn(alunoTurmaDTO);

        final AlunoTurmaDTO resposta = atualizarAlunoTurmaRepositoryAdapter.atualizar(alunoTurmaDTO);

        assertNotNull(resposta);
        assertEquals(alunoTurmaDTO, resposta);

        verify(alunoTurmaMapper).deAlunoTurmaDTOParaAlunoTurmaEntity(alunoTurmaDTO);
        verify(alunoTurmaRepository).save(alunoTurmaEntity);
        verify(alunoTurmaMapper).deAlunoTurmaEntityParaAlunoTurmaDTO(alunoTurmaEntity);
    }
}