package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.dto.FuncionarioDTO;
import br.com.olharpedagogicoia.application.exceptions.FuncionarioNaoEncontradoException;

public interface ValidarFuncionarioPortOut {

    public FuncionarioDTO validar(final String nomeUsuario, final String senha) throws FuncionarioNaoEncontradoException;

}