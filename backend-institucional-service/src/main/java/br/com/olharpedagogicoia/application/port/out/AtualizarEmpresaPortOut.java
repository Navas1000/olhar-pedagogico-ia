package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.dto.EmpresaDto;
import br.com.olharpedagogicoia.application.exceptions.EmpresaNaoEncontradaException;
import br.com.olharpedagogicoia.application.exceptions.IdEmpresaObrigatorioException;

public interface AtualizarEmpresaPortOut {

    public EmpresaDto atualizar(final EmpresaDto empresaDTO) throws EmpresaNaoEncontradaException, IdEmpresaObrigatorioException;

}
