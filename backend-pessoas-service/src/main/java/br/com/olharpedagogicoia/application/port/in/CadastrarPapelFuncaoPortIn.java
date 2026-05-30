package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.dto.PapelFuncaoDTO;

public interface CadastrarPapelFuncaoPortIn {

    public PapelFuncaoDTO cadastrar(final PapelFuncaoDTO papelFuncaoDTO);

}