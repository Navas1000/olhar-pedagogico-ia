package br.com.olharpedagogicoia.adapters.out.pessoa.mapper;

import br.com.olharpedagogicoia.adapters.out.pessoa.entity.PessoaEntity;
import br.com.olharpedagogicoia.application.dto.PessoaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PessoaMapper {

    PessoaDTO dePessoaEntityParaPessoaDTO(final PessoaEntity pessoaEntity);

    PessoaEntity dePessoaDTOParaPessoaEntity(final PessoaDTO pessoaDTO);

}