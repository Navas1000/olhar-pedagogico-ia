package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.dto.PessoaDTO;
import br.com.olharpedagogicoia.application.exceptions.PessoaNaoEncontradaException;

public interface ConsultarPessoaPortIn {

    public PessoaDTO consultar(final Integer id) throws PessoaNaoEncontradaException;

}