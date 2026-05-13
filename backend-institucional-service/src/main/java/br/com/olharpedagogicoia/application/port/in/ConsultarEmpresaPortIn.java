package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.dto.EmpresaDTO;
import br.com.olharpedagogicoia.application.exceptions.EmpresaNaoEncontradaException;

public interface ConsultarEmpresaPortIn {

    public EmpresaDTO consultar(final Integer id) throws EmpresaNaoEncontradaException;

}
