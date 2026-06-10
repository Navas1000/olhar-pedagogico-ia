package br.com.olharpedagogicoia.adapters.out.diarioAudio.mapper;

import br.com.olharpedagogicoia.adapters.out.diarioAudio.entity.DiarioAudioEntity;
import br.com.olharpedagogicoia.application.dto.DiarioAudioDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DiarioAudioMapper {

    DiarioAudioDTO deDiarioAudioEntityParaDiarioAudioDTO(
            final DiarioAudioEntity diarioAudioEntity
    );

    DiarioAudioEntity deDiarioAudioDTOParaDiarioAudioEntity(
            final DiarioAudioDTO diarioAudioDTO
    );
}