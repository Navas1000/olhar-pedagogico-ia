package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.dto.PapelFuncaoDTO;

public interface CadastrarPapelFuncaoPortOut {

    public PapelFuncaoDTO cadastrar(final PapelFuncaoDTO papelFuncaoDTO);

}