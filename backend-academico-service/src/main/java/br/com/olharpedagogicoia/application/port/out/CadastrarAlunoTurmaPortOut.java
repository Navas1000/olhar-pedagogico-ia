package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.dto.AlunoTurmaDTO;

public interface CadastrarAlunoTurmaPortOut {

    public AlunoTurmaDTO cadastrar(final AlunoTurmaDTO alunoTurmaDTO);

}