package br.com.olharpedagogicoia.adapters.out.professorTurma;

import br.com.olharpedagogicoia.adapters.out.professorTurma.entity.ProfessorTurmaEntity;
import br.com.olharpedagogicoia.adapters.out.professorTurma.mapper.ProfessorTurmaMapper;
import br.com.olharpedagogicoia.adapters.out.professorTurma.repository.ProfessorTurmaRepository;
import br.com.olharpedagogicoia.application.dto.ProfessorTurmaDTO;
import br.com.olharpedagogicoia.application.port.out.ConsultarProfessorTurmaPorFuncionarioPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ConsultarProfessorTurmaPorFuncionarioRepositoryAdapter
        implements ConsultarProfessorTurmaPorFuncionarioPortOut {

    private final ProfessorTurmaRepository professorTurmaRepository;
    private final ProfessorTurmaMapper professorTurmaMapper;

    @Override
    public List<ProfessorTurmaDTO> consultarPorFuncionario(
            final Integer idFuncionario) {

        final List<ProfessorTurmaEntity> alocacoes =
                professorTurmaRepository.findByIdFuncionario(idFuncionario);

        return alocacoes.stream()
                .map(professorTurmaMapper::deProfessorTurmaEntityParaProfessorTurmaDTO)
                .toList();
    }
}