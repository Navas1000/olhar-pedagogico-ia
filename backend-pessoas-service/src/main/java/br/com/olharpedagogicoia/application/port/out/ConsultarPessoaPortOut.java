package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.dto.PessoaDTO;
import br.com.olharpedagogicoia.application.exceptions.PessoaNaoEncontradaException;

public interface ConsultarPessoaPortOut {

    public PessoaDTO consultar(final Integer id) throws PessoaNaoEncontradaException;

}