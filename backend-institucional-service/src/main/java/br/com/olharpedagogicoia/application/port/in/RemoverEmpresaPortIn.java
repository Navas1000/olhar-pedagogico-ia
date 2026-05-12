package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.dto.EmpresaDTO;
import br.com.olharpedagogicoia.application.exceptions.EmpresaNaoEncontradaException;

public interface RemoverEmpresaPortIn {

    public void remover(final Integer idEmpresa) throws EmpresaNaoEncontradaException;

}
