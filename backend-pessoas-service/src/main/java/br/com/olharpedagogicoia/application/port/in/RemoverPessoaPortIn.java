package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.exceptions.PessoaNaoEncontradaException;

public interface RemoverPessoaPortIn {

    public void remover(final Integer id) throws PessoaNaoEncontradaException;

}