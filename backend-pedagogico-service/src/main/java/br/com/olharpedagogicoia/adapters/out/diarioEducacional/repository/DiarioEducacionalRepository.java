package br.com.olharpedagogicoia.adapters.out.diarioEducacional.repository;

import br.com.olharpedagogicoia.adapters.out.diarioEducacional.entity.DiarioEducacionalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiarioEducacionalRepository extends JpaRepository<DiarioEducacionalEntity, Integer> {
}