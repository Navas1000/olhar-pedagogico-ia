package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.dto.UnidadeDto;
import br.com.olharpedagogicoia.application.exceptions.UnidadeNaoEncontradaException;

public interface ConsultarUnidadePortOut {

    public UnidadeDto consultar(final Integer id) throws UnidadeNaoEncontradaException;

}
