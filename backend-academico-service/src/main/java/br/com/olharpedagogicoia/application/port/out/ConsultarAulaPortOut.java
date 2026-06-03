package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.dto.AulaDTO;
import br.com.olharpedagogicoia.application.exceptions.AulaNaoEncontradaException;

public interface ConsultarAulaPortOut {

    public AulaDTO consultar(final Integer id) throws AulaNaoEncontradaException;

}