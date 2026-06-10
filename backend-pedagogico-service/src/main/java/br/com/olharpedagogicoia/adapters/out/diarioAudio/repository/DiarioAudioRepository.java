package br.com.olharpedagogicoia.adapters.out.diarioAudio.repository;

import br.com.olharpedagogicoia.adapters.out.diarioAudio.entity.DiarioAudioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiarioAudioRepository extends JpaRepository<DiarioAudioEntity, Integer> {
}