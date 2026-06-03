package br.com.olharpedagogicoia.adapters.out.professorTurma;

import br.com.olharpedagogicoia.adapters.out.professorTurma.entity.ProfessorTurmaEntity;
import br.com.olharpedagogicoia.adapters.out.professorTurma.repository.ProfessorTurmaRepository;
import br.com.olharpedagogicoia.application.exceptions.Constantes;
import br.com.olharpedagogicoia.application.exceptions.ProfessorTurmaNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.out.RemoverProfessorTurmaPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RemoverProfessorTurmaRepositoryAdapter implements RemoverProfessorTurmaPortOut {

    private final ProfessorTurmaRepository professorTurmaRepository;

    @Override
    public void remover(final Integer id) throws ProfessorTurmaNaoEncontradaException {

        final Optional<ProfessorTurmaEntity> professorTurmaOpcional =
                professorTurmaRepository.findById(id);

        if (professorTurmaOpcional.isPresent())
            professorTurmaRepository.deleteById(id);
        else
            throw new ProfessorTurmaNaoEncontradaException(Constantes.PROFESSOR_TURMA_NAO_ENCONTRADA);
    }
}