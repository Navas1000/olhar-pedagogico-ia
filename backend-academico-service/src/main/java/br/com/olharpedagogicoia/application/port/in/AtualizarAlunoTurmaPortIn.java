package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.dto.AlunoTurmaDTO;
import br.com.olharpedagogicoia.application.exceptions.AlunoTurmaNaoEncontradaException;
import br.com.olharpedagogicoia.application.exceptions.IdAlunoTurmaObrigatorioException;

public interface AtualizarAlunoTurmaPortIn {

    public AlunoTurmaDTO atualizar(final AlunoTurmaDTO alunoTurmaDTO)
            throws AlunoTurmaNaoEncontradaException, IdAlunoTurmaObrigatorioException;

}