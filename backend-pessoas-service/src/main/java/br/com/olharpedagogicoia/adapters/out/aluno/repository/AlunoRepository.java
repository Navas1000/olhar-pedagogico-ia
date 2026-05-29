package br.com.olharpedagogicoia.adapters.out.aluno.repository;

import br.com.olharpedagogicoia.adapters.out.aluno.entity.AlunoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<AlunoEntity, Integer> {
}