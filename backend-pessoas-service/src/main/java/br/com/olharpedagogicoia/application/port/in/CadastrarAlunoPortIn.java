package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.dto.AlunoDTO;

public interface CadastrarAlunoPortIn {

    public AlunoDTO cadastrar(final AlunoDTO alunoDTO);

}