package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.dto.PapelFuncaoDTO;
import br.com.olharpedagogicoia.application.exceptions.PapelFuncaoNaoEncontradoException;

public interface ConsultarPapelFuncaoPortOut {

    public PapelFuncaoDTO consultar(final Integer id) throws PapelFuncaoNaoEncontradoException;

}