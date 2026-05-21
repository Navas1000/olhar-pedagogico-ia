package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.dto.TurmaDto;
import br.com.olharpedagogicoia.application.dto.UnidadeDto;
import br.com.olharpedagogicoia.application.exceptions.TurmaNaoEncontradaException;
import br.com.olharpedagogicoia.application.exceptions.UnidadeNaoEncontradaException;

public interface ConsultarTurmaPortIn {

    public TurmaDto consultar(final Integer id) throws TurmaNaoEncontradaException;

}
