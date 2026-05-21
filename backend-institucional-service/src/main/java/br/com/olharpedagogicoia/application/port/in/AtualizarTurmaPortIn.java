package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.dto.TurmaDto;
import br.com.olharpedagogicoia.application.dto.UnidadeDto;
import br.com.olharpedagogicoia.application.exceptions.IdTurmaObrigatorioException;
import br.com.olharpedagogicoia.application.exceptions.IdUnidadeObrigatorioException;
import br.com.olharpedagogicoia.application.exceptions.TurmaNaoEncontradaException;
import br.com.olharpedagogicoia.application.exceptions.UnidadeNaoEncontradaException;

public interface AtualizarTurmaPortIn {

    public TurmaDto atualizar(final TurmaDto turmaDto) throws TurmaNaoEncontradaException, IdTurmaObrigatorioException;

}
