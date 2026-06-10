package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.dto.FuncionarioDTO;
import br.com.olharpedagogicoia.application.exceptions.FuncionarioNaoEncontradoException;

public interface ValidarFuncionarioPortIn {

    public FuncionarioDTO validar(final FuncionarioDTO funcionarioDTO) throws FuncionarioNaoEncontradoException;

}