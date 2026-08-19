package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.dto.AlunoTurmaDTO;

import java.util.List;

public interface ConsultarAlunoTurmaPorTurmaPortOut {

    List<AlunoTurmaDTO> consultarPorTurma(
            final Integer idTurma
    );

}