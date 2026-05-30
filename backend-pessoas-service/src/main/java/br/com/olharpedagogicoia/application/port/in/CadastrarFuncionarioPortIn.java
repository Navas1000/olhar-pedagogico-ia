package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.dto.FuncionarioDTO;

public interface CadastrarFuncionarioPortIn {

    public FuncionarioDTO cadastrar(final FuncionarioDTO funcionarioDTO);

}