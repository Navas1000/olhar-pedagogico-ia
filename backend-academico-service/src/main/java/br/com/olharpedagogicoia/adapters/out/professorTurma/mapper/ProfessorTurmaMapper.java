package br.com.olharpedagogicoia.adapters.out.professorTurma.mapper;

import br.com.olharpedagogicoia.adapters.out.professorTurma.entity.ProfessorTurmaEntity;
import br.com.olharpedagogicoia.application.dto.ProfessorTurmaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfessorTurmaMapper {

    ProfessorTurmaDTO deProfessorTurmaEntityParaProfessorTurmaDTO(final ProfessorTurmaEntity professorTurmaEntity);

    ProfessorTurmaEntity deProfessorTurmaDTOParaProfessorTurmaEntity(final ProfessorTurmaDTO professorTurmaDTO);

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