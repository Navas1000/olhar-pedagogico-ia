package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.dto.EmpresaDto;
import br.com.olharpedagogicoia.application.exceptions.EmpresaNaoEncontradaException;

public interface ConsultarEmpresaPortOut {

    public EmpresaDto consultar(final Integer id) throws EmpresaNaoEncontradaException;

}
