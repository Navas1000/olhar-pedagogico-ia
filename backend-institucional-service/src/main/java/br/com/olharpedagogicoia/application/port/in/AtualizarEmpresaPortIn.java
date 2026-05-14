package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.dto.EmpresaDto;
import br.com.olharpedagogicoia.application.exceptions.EmpresaNaoEncontradaException;
import br.com.olharpedagogicoia.application.exceptions.IdEmpresaObrigatorioException;

public interface AtualizarEmpresaPortIn {

    public EmpresaDto atualizar(final EmpresaDto empresaDTO) throws EmpresaNaoEncontradaException, IdEmpresaObrigatorioException;

}
