package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.dto.AlunoDTO;
import br.com.olharpedagogicoia.application.exceptions.AlunoNaoEncontradoException;

public interface ConsultarAlunoPortOut {

    public AlunoDTO consultar(final Integer id) throws AlunoNaoEncontradoException;

}