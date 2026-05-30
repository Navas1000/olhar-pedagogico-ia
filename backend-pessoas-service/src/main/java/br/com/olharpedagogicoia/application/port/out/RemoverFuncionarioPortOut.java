package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.exceptions.FuncionarioNaoEncontradoException;

public interface RemoverFuncionarioPortOut {

    public void remover(final Integer id) throws FuncionarioNaoEncontradoException;

}