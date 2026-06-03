package br.com.olharpedagogicoia.adapters.out.aula.repository;

import br.com.olharpedagogicoia.adapters.out.aula.entity.AulaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AulaRepository extends JpaRepository<AulaEntity, Integer> {
}