package br.com.olharpedagogicoia.adapters.out.resumoEducacional.mapper;

import br.com.olharpedagogicoia.adapters.out.resumoEducacional.entity.ResumoEducacionalEntity;
import br.com.olharpedagogicoia.application.dto.ResumoEducacionalDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ResumoEducacionalMapper {

    ResumoEducacionalDTO deResumoEducacionalEntityParaResumoEducacionalDTO(
            final ResumoEducacionalEntity resumoEducacionalEntity
    );

    ResumoEducacionalEntity deResumoEducacionalDTOParaResumoEducacionalEntity(
            final ResumoEducacionalDTO resumoEducacionalDTO
    );
}