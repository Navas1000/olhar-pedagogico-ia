package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.dto.FuncionarioDTO;
import br.com.olharpedagogicoia.application.exceptions.FuncionarioNaoEncontradoException;

public interface ConsultarFuncionarioPortOut {

    public FuncionarioDTO consultar(final Integer id) throws FuncionarioNaoEncontradoException;

}