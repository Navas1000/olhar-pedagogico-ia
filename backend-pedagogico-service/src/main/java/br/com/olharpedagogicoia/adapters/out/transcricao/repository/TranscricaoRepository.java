package br.com.olharpedagogicoia.adapters.out.transcricao.repository;

import br.com.olharpedagogicoia.adapters.out.transcricao.entity.TranscricaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TranscricaoRepository extends JpaRepository<TranscricaoEntity, Integer> {
}