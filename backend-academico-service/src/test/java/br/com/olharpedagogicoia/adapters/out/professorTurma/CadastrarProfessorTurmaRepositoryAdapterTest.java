package br.com.olharpedagogicoia.adapters.out.professorTurma;

import br.com.olharpedagogicoia.adapters.out.professorTurma.entity.ProfessorTurmaEntity;
import br.com.olharpedagogicoia.adapters.out.professorTurma.mapper.ProfessorTurmaMapper;
import br.com.olharpedagogicoia.adapters.out.professorTurma.repository.ProfessorTurmaRepository;
import br.com.olharpedagogicoia.application.dto.ProfessorTurmaDTO;
import br.com.olharpedagogicoia.application.stub.ProfessorTurmaStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CadastrarProfessorTurmaRepositoryAdapterTest {

    @Mock
    private ProfessorTurmaRepository professorTurmaRepository;

    @Mock
    private ProfessorTurmaMapper professorTurmaMapper;

    @InjectMocks
    private CadastrarProfessorTurmaRepositoryAdapter cadastrarProfessorTurmaRepositoryAdapter;

    @Test
    void deveCadastrarProfessorTurmaComSucesso() {

        final ProfessorTurmaDTO professorTurmaDTO = ProfessorTurmaStub.getProfessorTurmaCompleta();
        final ProfessorTurmaEntity professorTurmaEntity = new ProfessorTurmaEntity();

        when(professorTurmaMapper.deProfessorTurmaDTOParaProfessorTurmaEntity(professorTurmaDTO)).thenReturn(professorTurmaEntity);
        when(professorTurmaRepository.save(professorTurmaEntity)).thenReturn(professorTurmaEntity);
        when(professorTurmaMapper.deProfessorTurmaEntityParaProfessorTurmaDTO(professorTurmaEntity)).thenReturn(professorTurmaDTO);

        final ProfessorTurmaDTO resposta = cadastrarProfessorTurmaRepositoryAdapter.cadastrar(professorTurmaDTO);

        assertNotNull(resposta);
        assertEquals(professorTurmaDTO, resposta);

        verify(professorTurmaMapper).deProfessorTurmaDTOParaProfessorTurmaEntity(professorTurmaDTO);
        verify(professorTurmaRepository).save(professorTurmaEntity);
        verify(professorTurmaMapper).deProfessorTurmaEntityParaProfessorTurmaDTO(professorTurmaEntity);
    }
}