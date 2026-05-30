package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.dto.AlunoDTO;

public interface AtualizarAlunoPortOut {

    public AlunoDTO atualizar(final AlunoDTO alunoDTO);

}