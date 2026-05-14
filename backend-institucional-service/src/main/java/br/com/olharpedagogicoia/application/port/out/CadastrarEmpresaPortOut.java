package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.dto.EmpresaDto;

public interface CadastrarEmpresaPortOut {

    public EmpresaDto cadastrar(final EmpresaDto empresaDTO);

}
