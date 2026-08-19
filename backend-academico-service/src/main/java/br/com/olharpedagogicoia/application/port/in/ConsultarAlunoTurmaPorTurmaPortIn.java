package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.dto.AlunoTurmaDTO;

import java.util.List;

public interface ConsultarAlunoTurmaPorTurmaPortIn {

    List<AlunoTurmaDTO> consultarPorTurma(
            final Integer idTurma
    );

}