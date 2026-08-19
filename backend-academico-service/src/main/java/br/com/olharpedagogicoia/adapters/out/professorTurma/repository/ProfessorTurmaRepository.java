package br.com.olharpedagogicoia.adapters.out.professorTurma.repository;

import br.com.olharpedagogicoia.adapters.out.professorTurma.entity.ProfessorTurmaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfessorTurmaRepository
        extends JpaRepository<ProfessorTurmaEntity, Integer> {

    List<ProfessorTurmaEntity> findByIdFuncionario(
            final Integer idFuncionario
    );
}