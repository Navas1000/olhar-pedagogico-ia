package br.com.olharpedagogicoia.adapters.out.alunoTurma.repository;

import br.com.olharpedagogicoia.adapters.out.alunoTurma.entity.AlunoTurmaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoTurmaRepository extends JpaRepository<AlunoTurmaEntity, Integer> {
}