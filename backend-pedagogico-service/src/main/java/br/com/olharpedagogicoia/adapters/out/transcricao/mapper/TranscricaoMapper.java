package br.com.olharpedagogicoia.adapters.out.transcricao.mapper;

import br.com.olharpedagogicoia.adapters.out.transcricao.entity.TranscricaoEntity;
import br.com.olharpedagogicoia.application.dto.TranscricaoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TranscricaoMapper {

    TranscricaoDTO deTranscricaoEntityParaTranscricaoDTO(
            final TranscricaoEntity transcricaoEntity
    );

    TranscricaoEntity deTranscricaoDTOParaTranscricaoEntity(
            final TranscricaoDTO transcricaoDTO
    );
}