package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.dto.AulaDTO;
import br.com.olharpedagogicoia.application.exceptions.AulaNaoEncontradaException;
import br.com.olharpedagogicoia.application.exceptions.IdAulaObrigatorioException;

public interface AtualizarAulaPortIn {

    public AulaDTO atualizar(final AulaDTO aulaDTO)
            throws AulaNaoEncontradaException, IdAulaObrigatorioException;

}