package br.com.olharpedagogicoia.adapters.out.turma.repository;

import br.com.olharpedagogicoia.adapters.out.turma.entity.TurmaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurmaRepository extends JpaRepository<TurmaEntity, Integer> {
}
