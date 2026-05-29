package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.dto.AlunoDTO;
import br.com.olharpedagogicoia.application.exceptions.AlunoNaoEncontradoException;

public interface ConsultarAlunoPortIn {

    public AlunoDTO consultar(final Integer id) throws AlunoNaoEncontradoException;

}