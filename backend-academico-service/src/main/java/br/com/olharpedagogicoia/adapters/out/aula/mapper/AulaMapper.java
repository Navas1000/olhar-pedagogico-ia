package br.com.olharpedagogicoia.adapters.out.aula.mapper;

import br.com.olharpedagogicoia.adapters.out.aula.entity.AulaEntity;
import br.com.olharpedagogicoia.application.dto.AulaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AulaMapper {

    AulaDTO deAulaEntityParaAulaDTO(final AulaEntity aulaEntity);

    AulaEntity deAulaDTOParaAulaEntity(final AulaDTO aulaDTO);
}