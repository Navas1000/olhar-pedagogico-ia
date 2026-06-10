package br.com.olharpedagogicoia.adapters.out.diarioEducacional.mapper;

import br.com.olharpedagogicoia.adapters.out.diarioEducacional.entity.DiarioEducacionalEntity;
import br.com.olharpedagogicoia.application.dto.DiarioEducacionalDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DiarioEducacionalMapper {

    DiarioEducacionalDTO deDiarioEducacionalEntityParaDiarioEducacionalDTO(
            final DiarioEducacionalEntity diarioEducacionalEntity
    );

    DiarioEducacionalEntity deDiarioEducacionalDTOParaDiarioEducacionalEntity(
            final DiarioEducacionalDTO diarioEducacionalDTO
    );
}