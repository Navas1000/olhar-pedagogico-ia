package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.dto.AlunoTurmaDTO;

public interface CadastrarAlunoTurmaPortIn {

    public AlunoTurmaDTO cadastrar(final AlunoTurmaDTO alunoTurmaDTO);

}