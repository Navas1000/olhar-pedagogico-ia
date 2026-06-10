package br.com.olharpedagogicoia.adapters.out.resumoEducacional.repository;

import br.com.olharpedagogicoia.adapters.out.resumoEducacional.entity.ResumoEducacionalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumoEducacionalRepository extends JpaRepository<ResumoEducacionalEntity, Integer> {
}