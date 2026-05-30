package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.dto.PessoaDTO;

public interface CadastrarPessoaPortIn {

    public PessoaDTO cadastrar(final PessoaDTO pessoaDTO);

}