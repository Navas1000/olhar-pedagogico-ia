package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.dto.PapelFuncaoDTO;

public interface AtualizarPapelFuncaoPortOut {

    public PapelFuncaoDTO atualizar(final PapelFuncaoDTO papelFuncaoDTO);

}