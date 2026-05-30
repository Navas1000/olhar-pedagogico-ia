package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.dto.FuncionarioDTO;

public interface AtualizarFuncionarioPortOut {

    public FuncionarioDTO atualizar(final FuncionarioDTO funcionarioDTO);

}