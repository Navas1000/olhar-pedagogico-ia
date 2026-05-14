package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.dto.EmpresaDto;
import br.com.olharpedagogicoia.application.exceptions.EmpresaNaoEncontradaException;

public interface ConsultarEmpresaPortIn {

    public EmpresaDto consultar(final Integer id) throws EmpresaNaoEncontradaException;

}
