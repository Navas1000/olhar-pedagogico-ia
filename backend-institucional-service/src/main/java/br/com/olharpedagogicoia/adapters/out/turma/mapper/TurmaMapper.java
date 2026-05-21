package br.com.olharpedagogicoia.adapters.out.turma.mapper;

import br.com.olharpedagogicoia.adapters.out.turma.entity.TurmaEntity;
import br.com.olharpedagogicoia.adapters.out.unidade.entity.UnidadeEntity;
import br.com.olharpedagogicoia.application.dto.TurmaDto;
import br.com.olharpedagogicoia.application.dto.UnidadeDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TurmaMapper {

    TurmaDto deTurmaEntityParaTurmaDTO(final TurmaEntity turmaEntity);

    TurmaEntity deTurmaDTOParaTurmaEntity(final TurmaDto turmaDto);

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
