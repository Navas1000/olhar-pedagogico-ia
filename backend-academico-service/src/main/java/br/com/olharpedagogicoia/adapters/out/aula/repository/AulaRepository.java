package br.com.olharpedagogicoia.adapters.out.aula.repository;

import br.com.olharpedagogicoia.adapters.out.aula.entity.AulaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AulaRepository
        extends JpaRepository<AulaEntity, Integer> {

    List<AulaEntity> findByIdAlocacao(
            final Integer idAlocacao
    );
}