package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.dto.AulaDTO;
import br.com.olharpedagogicoia.application.exceptions.AulaNaoEncontradaException;

public interface ConsultarAulaPortIn {

    public AulaDTO consultar(final Integer id) throws AulaNaoEncontradaException;

}