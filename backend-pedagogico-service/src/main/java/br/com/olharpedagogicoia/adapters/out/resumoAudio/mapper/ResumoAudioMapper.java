package br.com.olharpedagogicoia.adapters.out.resumoAudio.mapper;

import br.com.olharpedagogicoia.adapters.out.resumoAudio.entity.ResumoAudioEntity;
import br.com.olharpedagogicoia.application.dto.ResumoAudioDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ResumoAudioMapper {

    ResumoAudioDTO deResumoAudioEntityParaResumoAudioDTO(
            final ResumoAudioEntity resumoAudioEntity
    );

    ResumoAudioEntity deResumoAudioDTOParaResumoAudioEntity(
            final ResumoAudioDTO resumoAudioDTO
    );
}