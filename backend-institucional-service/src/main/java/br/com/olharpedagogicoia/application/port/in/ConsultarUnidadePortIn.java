package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.dto.UnidadeDto;
import br.com.olharpedagogicoia.application.exceptions.UnidadeNaoEncontradaException;

public interface ConsultarUnidadePortIn {

    public UnidadeDto consultar(final Integer id) throws UnidadeNaoEncontradaException;

}
