package br.com.olharpedagogicoia.adapters.out.papelFuncao.mapper;

import br.com.olharpedagogicoia.adapters.out.papelFuncao.entity.PapelFuncaoEntity;
import br.com.olharpedagogicoia.application.dto.PapelFuncaoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PapelFuncaoMapper {

    PapelFuncaoDTO dePapelFuncaoEntityParaPapelFuncaoDTO(final PapelFuncaoEntity papelFuncaoEntity);

    PapelFuncaoEntity dePapelFuncaoDTOParaPapelFuncaoEntity(final PapelFuncaoDTO papelFuncaoDTO);

}