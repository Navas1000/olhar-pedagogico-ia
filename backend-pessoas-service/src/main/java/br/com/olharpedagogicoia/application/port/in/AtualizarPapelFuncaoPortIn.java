package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.dto.PapelFuncaoDTO;
import br.com.olharpedagogicoia.application.exceptions.IdPapelFuncaoObrigatorioException;
import br.com.olharpedagogicoia.application.exceptions.PapelFuncaoNaoEncontradoException;

public interface AtualizarPapelFuncaoPortIn {

    public PapelFuncaoDTO atualizar(final PapelFuncaoDTO papelFuncaoDTO) throws PapelFuncaoNaoEncontradoException, IdPapelFuncaoObrigatorioException;

}