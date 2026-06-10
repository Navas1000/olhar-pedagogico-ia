package br.com.olharpedagogicoia.adapters.out.resumoAudio.repository;

import br.com.olharpedagogicoia.adapters.out.resumoAudio.entity.ResumoAudioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumoAudioRepository extends JpaRepository<ResumoAudioEntity, Integer> {
}