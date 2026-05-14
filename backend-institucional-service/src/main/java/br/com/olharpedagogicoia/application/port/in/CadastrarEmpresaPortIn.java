package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.dto.EmpresaDto;

public interface CadastrarEmpresaPortIn {

    public EmpresaDto cadastrar(final EmpresaDto empresaDTO);

}
