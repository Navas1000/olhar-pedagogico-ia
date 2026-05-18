package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.dto.EmpresaDto;
import br.com.olharpedagogicoia.application.dto.UnidadeDto;

public interface CadastrarUnidadePortOut {

    public UnidadeDto cadastrar(final UnidadeDto unidadeDto);

}
