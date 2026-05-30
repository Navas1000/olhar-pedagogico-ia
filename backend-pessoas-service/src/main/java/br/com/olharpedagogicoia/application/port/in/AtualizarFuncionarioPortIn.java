package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.dto.FuncionarioDTO;
import br.com.olharpedagogicoia.application.exceptions.FuncionarioNaoEncontradoException;
import br.com.olharpedagogicoia.application.exceptions.IdFuncionarioObrigatorioException;

public interface AtualizarFuncionarioPortIn {

    public FuncionarioDTO atualizar(final FuncionarioDTO funcionarioDTO) throws FuncionarioNaoEncontradoException, IdFuncionarioObrigatorioException;

}