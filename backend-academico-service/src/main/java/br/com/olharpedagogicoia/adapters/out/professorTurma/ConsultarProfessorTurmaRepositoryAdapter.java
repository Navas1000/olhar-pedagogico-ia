package br.com.olharpedagogicoia.adapters.out.professorTurma;

import br.com.olharpedagogicoia.adapters.out.professorTurma.entity.ProfessorTurmaEntity;
import br.com.olharpedagogicoia.adapters.out.professorTurma.mapper.ProfessorTurmaMapper;
import br.com.olharpedagogicoia.adapters.out.professorTurma.repository.ProfessorTurmaRepository;
import br.com.olharpedagogicoia.application.dto.ProfessorTurmaDTO;
import br.com.olharpedagogicoia.application.exceptions.Constantes;
import br.com.olharpedagogicoia.application.exceptions.ProfessorTurmaNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.out.ConsultarProfessorTurmaPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ConsultarProfessorTurmaRepositoryAdapter implements ConsultarProfessorTurmaPortOut {

    private final ProfessorTurmaRepository professorTurmaRepository;
    private final ProfessorTurmaMapper professorTurmaMapper;

    @Override
    public ProfessorTurmaDTO consultar(final Integer id) throws ProfessorTurmaNaoEncontradaException {

        final Optional<ProfessorTurmaEntity> professorTurmaOpcional =
                professorTurmaRepository.findById(id);

        if (professorTurmaOpcional.isPresent())
            return professorTurmaMapper.deProfessorTurmaEntityParaProfessorTurmaDTO(professorTurmaOpcional.get());

        throw new ProfessorTurmaNaoEncontradaException(Constantes.PROFESSOR_TURMA_NAO_ENCONTRADA);
    }
}