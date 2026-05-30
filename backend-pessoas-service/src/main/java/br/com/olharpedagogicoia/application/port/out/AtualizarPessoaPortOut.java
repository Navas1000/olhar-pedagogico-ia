package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.dto.PessoaDTO;

public interface AtualizarPessoaPortOut {

    public PessoaDTO atualizar(final PessoaDTO pessoaDTO);

}