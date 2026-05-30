package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.dto.PessoaDTO;

public interface CadastrarPessoaPortOut {

    public PessoaDTO cadastrar(final PessoaDTO pessoaDTO);

}