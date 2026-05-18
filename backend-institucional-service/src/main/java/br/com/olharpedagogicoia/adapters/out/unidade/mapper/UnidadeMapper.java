package br.com.olharpedagogicoia.adapters.out.unidade.mapper;

import br.com.olharpedagogicoia.adapters.out.unidade.entity.UnidadeEntity;
import br.com.olharpedagogicoia.application.dto.UnidadeDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UnidadeMapper {

    UnidadeDto deUnidadeEntityParaUnidadeDTO(final UnidadeEntity unidadeEntity);

    UnidadeEntity deUnidadeDTOParaUnidadeEntity(final UnidadeDto unidadeDto);



}
