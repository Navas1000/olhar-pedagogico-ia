package br.com.olharpedagogicoia.adapters.out.empresa.mapper;

import br.com.olharpedagogicoia.adapters.out.empresa.entity.EmpresaEntity;
import br.com.olharpedagogicoia.application.dto.EmpresaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmpresaMapper {

    EmpresaDTO deEmpresaEntityParaEmpresaDTO(final EmpresaEntity empresaEntity);

    EmpresaEntity deEmpresaDTOParaEmpresaEntity(final EmpresaDTO empresaDTO);

    static Boolean map(final Short valor) {
       return valor==1;
    }
    static Short map(final Boolean valor) {
        if (valor)
            return 1;
        else
            return 0;
    }
}
