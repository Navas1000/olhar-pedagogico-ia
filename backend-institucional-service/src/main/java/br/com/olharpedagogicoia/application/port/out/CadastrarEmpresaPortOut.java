package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.dto.EmpresaDTO;
import br.com.olharpedagogicoia.application.exceptions.EmpresaNaoEncontradaException;

public interface CadastrarEmpresaPortOut {

    public EmpresaDTO cadastrar(final EmpresaDTO empresaDTO);

}
