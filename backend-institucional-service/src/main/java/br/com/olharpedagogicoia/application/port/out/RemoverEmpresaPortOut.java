package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.exceptions.EmpresaNaoEncontradaException;

public interface RemoverEmpresaPortOut {

    public void remover(final Integer idEmpresa) throws EmpresaNaoEncontradaException;

}
