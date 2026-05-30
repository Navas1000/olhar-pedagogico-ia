package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.exceptions.AlunoNaoEncontradoException;

public interface RemoverAlunoPortOut {

    public void remover(final Integer id) throws AlunoNaoEncontradoException;

}