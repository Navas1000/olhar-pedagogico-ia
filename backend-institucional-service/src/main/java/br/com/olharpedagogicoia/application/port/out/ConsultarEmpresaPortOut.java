package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.dto.EmpresaDTO;
import br.com.olharpedagogicoia.application.exceptions.EmpresaNaoEncontradaException;

public interface ConsultarEmpresaPortOut {

    public EmpresaDTO consultar(Integer id) throws EmpresaNaoEncontradaException;

}
