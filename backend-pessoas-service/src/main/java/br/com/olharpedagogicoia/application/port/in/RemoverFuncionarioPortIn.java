package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.exceptions.FuncionarioNaoEncontradoException;

public interface RemoverFuncionarioPortIn {

    public void remover(final Integer id) throws FuncionarioNaoEncontradoException;

}