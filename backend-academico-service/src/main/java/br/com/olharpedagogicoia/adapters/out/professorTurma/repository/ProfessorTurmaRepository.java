package br.com.olharpedagogicoia.adapters.out.professorTurma.repository;

import br.com.olharpedagogicoia.adapters.out.professorTurma.entity.ProfessorTurmaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorTurmaRepository extends JpaRepository<ProfessorTurmaEntity, Integer> {
}