package br.com.olharpedagogicoia.adapters.out.alunoTurma.mapper;

import br.com.olharpedagogicoia.adapters.out.alunoTurma.entity.AlunoTurmaEntity;
import br.com.olharpedagogicoia.application.dto.AlunoTurmaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AlunoTurmaMapper {

    AlunoTurmaDTO deAlunoTurmaEntityParaAlunoTurmaDTO(
            final AlunoTurmaEntity alunoTurmaEntity
    );

    AlunoTurmaEntity deAlunoTurmaDTOParaAlunoTurmaEntity(
            final AlunoTurmaDTO alunoTurmaDTO
    );
}