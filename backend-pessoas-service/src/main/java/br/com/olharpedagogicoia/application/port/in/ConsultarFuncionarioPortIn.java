package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.dto.FuncionarioDTO;
import br.com.olharpedagogicoia.application.exceptions.FuncionarioNaoEncontradoException;

public interface ConsultarFuncionarioPortIn {

    public FuncionarioDTO consultar(final Integer id) throws FuncionarioNaoEncontradoException;

}