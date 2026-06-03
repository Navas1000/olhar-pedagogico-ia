package br.com.olharpedagogicoia.adapters.out.professorTurma;

import br.com.olharpedagogicoia.adapters.out.professorTurma.entity.ProfessorTurmaEntity;
import br.com.olharpedagogicoia.adapters.out.professorTurma.mapper.ProfessorTurmaMapper;
import br.com.olharpedagogicoia.adapters.out.professorTurma.repository.ProfessorTurmaRepository;
import br.com.olharpedagogicoia.application.dto.ProfessorTurmaDTO;
import br.com.olharpedagogicoia.application.port.out.CadastrarProfessorTurmaPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CadastrarProfessorTurmaRepositoryAdapter implements CadastrarProfessorTurmaPortOut {

    private final ProfessorTurmaRepository professorTurmaRepository;
    private final ProfessorTurmaMapper professorTurmaMapper;

    @Override
    public ProfessorTurmaDTO cadastrar(final ProfessorTurmaDTO professorTurmaDTO) {

        final ProfessorTurmaEntity professorTurmaEntity =
                professorTurmaMapper.deProfessorTurmaDTOParaProfessorTurmaEntity(professorTurmaDTO);

        final ProfessorTurmaEntity professorTurmaSalvo =
                professorTurmaRepository.save(professorTurmaEntity);

        return professorTurmaMapper.deProfessorTurmaEntityParaProfessorTurmaDTO(professorTurmaSalvo);
    }
}