package br.com.olharpedagogicoia.adapters.out.funcionario.mapper;

import br.com.olharpedagogicoia.adapters.out.funcionario.entity.FuncionarioEntity;
import br.com.olharpedagogicoia.application.dto.FuncionarioDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FuncionarioMapper {

    FuncionarioDTO deFuncionarioEntityParaFuncionarioDTO(final FuncionarioEntity funcionarioEntity);

    FuncionarioEntity deFuncionarioDTOParaFuncionarioEntity(final FuncionarioDTO funcionarioDTO);

    static Boolean map(final Short valor) {
        return valor == 1;
    }

    static Short map(final Boolean valor) {
        if (valor)
            return 1;
        else
            return 0;
    }
}