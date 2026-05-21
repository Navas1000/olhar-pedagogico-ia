package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.dto.EmpresaDto;
import br.com.olharpedagogicoia.application.dto.UnidadeDto;
import br.com.olharpedagogicoia.application.exceptions.EmpresaNaoEncontradaException;
import br.com.olharpedagogicoia.application.exceptions.IdEmpresaObrigatorioException;
import br.com.olharpedagogicoia.application.exceptions.IdUnidadeObrigatorioException;
import br.com.olharpedagogicoia.application.exceptions.UnidadeNaoEncontradaException;

public interface AtualizarUnidadePortOut {

    public UnidadeDto atualizar(final UnidadeDto unidadeDto) throws UnidadeNaoEncontradaException, IdUnidadeObrigatorioException;

}
