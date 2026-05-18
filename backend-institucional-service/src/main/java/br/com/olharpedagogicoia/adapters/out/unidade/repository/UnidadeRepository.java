package br.com.olharpedagogicoia.adapters.out.unidade.repository;

import br.com.olharpedagogicoia.adapters.out.unidade.entity.UnidadeEntity;
import br.com.olharpedagogicoia.application.dto.UnidadeDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnidadeRepository extends JpaRepository<UnidadeEntity, Integer> {
}
