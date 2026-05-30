package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.dto.FuncionarioDTO;

public interface CadastrarFuncionarioPortOut {

    public FuncionarioDTO cadastrar(final FuncionarioDTO funcionarioDTO);

}