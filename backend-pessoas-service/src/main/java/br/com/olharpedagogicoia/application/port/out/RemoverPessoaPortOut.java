package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.exceptions.PessoaNaoEncontradaException;

public interface RemoverPessoaPortOut {

    public void remover(final Integer id) throws PessoaNaoEncontradaException;

}