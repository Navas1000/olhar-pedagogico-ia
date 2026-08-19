package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.dto.ProfessorTurmaDTO;

import java.util.List;

public interface ConsultarProfessorTurmaPorFuncionarioPortOut {

    List<ProfessorTurmaDTO> consultarPorFuncionario(
            final Integer idFuncionario
    );
}