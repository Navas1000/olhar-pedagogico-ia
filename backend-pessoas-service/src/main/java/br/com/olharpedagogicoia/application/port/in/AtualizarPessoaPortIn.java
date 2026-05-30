package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.dto.PessoaDTO;
import br.com.olharpedagogicoia.application.exceptions.IdPessoaObrigatorioException;
import br.com.olharpedagogicoia.application.exceptions.PessoaNaoEncontradaException;

public interface AtualizarPessoaPortIn {

    public PessoaDTO atualizar(final PessoaDTO pessoaDTO) throws PessoaNaoEncontradaException, IdPessoaObrigatorioException;

}