package br.com.olharpedagogicoia.adapters.out.professorTurma;

import br.com.olharpedagogicoia.adapters.out.professorTurma.entity.ProfessorTurmaEntity;
import br.com.olharpedagogicoia.adapters.out.professorTurma.mapper.ProfessorTurmaMapper;
import br.com.olharpedagogicoia.adapters.out.professorTurma.repository.ProfessorTurmaRepository;
import br.com.olharpedagogicoia.application.dto.ProfessorTurmaDTO;
import br.com.olharpedagogicoia.application.exceptions.ProfessorTurmaNaoEncontradaException;
import br.com.olharpedagogicoia.application.stub.ProfessorTurmaStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ConsultarProfessorTurmaRepositoryAdapterTest {

    @Mock
    private ProfessorTurmaRepository professorTurmaRepository;

    @Mock
    private ProfessorTurmaMapper professorTurmaMapper;

    @InjectMocks
    private ConsultarProfessorTurmaRepositoryAdapter consultarProfessorTurmaRepositoryAdapter;

    @Test
    void deveConsultarProfessorTurmaComSucesso() throws ProfessorTurmaNaoEncontradaException {

        final Integer idAlocacao = 1;
        final ProfessorTurmaDTO professorTurmaDTO = ProfessorTurmaStub.getProfessorTurmaCompleta();
        final ProfessorTurmaEntity professorTurmaEntity = new ProfessorTurmaEntity();

        when(professorTurmaRepository.findById(idAlocacao)).thenReturn(Optional.of(professorTurmaEntity));
        when(professorTurmaMapper.deProfessorTurmaEntityParaProfessorTurmaDTO(professorTurmaEntity)).thenReturn(professorTurmaDTO);

        final ProfessorTurmaDTO resposta = consultarProfessorTurmaRepositoryAdapter.consultar(idAlocacao);

        assertNotNull(resposta);
        assertEquals(professorTurmaDTO, resposta);

        verify(professorTurmaRepository).findById(idAlocacao);
        verify(professorTurmaMapper).deProfessorTurmaEntityParaProfessorTurmaDTO(professorTurmaEntity);
    }

    @Test
    void deveLancarExcecaoQuandoProfessorTurmaNaoForEncontrado() {

        final Integer idAlocacao = 1;

        when(professorTurmaRepository.findById(idAlocacao)).thenReturn(Optional.empty());

        assertThrows(
                ProfessorTurmaNaoEncontradaException.class,
                () -> consultarProfessorTurmaRepositoryAdapter.consultar(idAlocacao)
        );

        verify(professorTurmaRepository).findById(idAlocacao);
        verifyNoInteractions(professorTurmaMapper);
    }
}