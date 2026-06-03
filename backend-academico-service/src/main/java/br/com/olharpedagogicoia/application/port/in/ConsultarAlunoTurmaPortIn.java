package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.dto.AlunoTurmaDTO;
import br.com.olharpedagogicoia.application.exceptions.AlunoTurmaNaoEncontradaException;

public interface ConsultarAlunoTurmaPortIn {

    public AlunoTurmaDTO consultar(final Integer id) throws AlunoTurmaNaoEncontradaException;

}