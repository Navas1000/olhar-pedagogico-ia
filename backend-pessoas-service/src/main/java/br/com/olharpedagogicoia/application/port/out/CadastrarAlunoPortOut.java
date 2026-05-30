package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.dto.AlunoDTO;

public interface CadastrarAlunoPortOut {

    public AlunoDTO cadastrar(final AlunoDTO alunoDTO);

}