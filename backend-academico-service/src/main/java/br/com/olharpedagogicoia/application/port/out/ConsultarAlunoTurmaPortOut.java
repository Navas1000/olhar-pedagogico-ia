package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.dto.AlunoTurmaDTO;
import br.com.olharpedagogicoia.application.exceptions.AlunoTurmaNaoEncontradaException;

public interface ConsultarAlunoTurmaPortOut {

    public AlunoTurmaDTO consultar(final Integer id) throws AlunoTurmaNaoEncontradaException;

}