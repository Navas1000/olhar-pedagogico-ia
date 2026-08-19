package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.dto.ProfessorTurmaDTO;

import java.util.List;

public interface ConsultarProfessorTurmaPorFuncionarioPortIn {

    List<ProfessorTurmaDTO> consultarPorFuncionario(
            final Integer idFuncionario
    );
}