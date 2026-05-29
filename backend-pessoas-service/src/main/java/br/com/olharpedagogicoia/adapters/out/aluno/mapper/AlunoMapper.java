package br.com.olharpedagogicoia.adapters.out.aluno.mapper;

import br.com.olharpedagogicoia.adapters.out.aluno.entity.AlunoEntity;
import br.com.olharpedagogicoia.application.dto.AlunoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AlunoMapper {

    AlunoDTO deAlunoEntityParaAlunoDTO(final AlunoEntity alunoEntity);

    AlunoEntity deAlunoDTOParaAlunoEntity(final AlunoDTO alunoDTO);

}