package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.dto.PapelFuncaoDTO;
import br.com.olharpedagogicoia.application.exceptions.PapelFuncaoNaoEncontradoException;

public interface ConsultarPapelFuncaoPortIn {

    public PapelFuncaoDTO consultar(final Integer id) throws PapelFuncaoNaoEncontradoException;

}