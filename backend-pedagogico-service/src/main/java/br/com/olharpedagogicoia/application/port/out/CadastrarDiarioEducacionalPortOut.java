package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.dto.DiarioEducacionalDTO;

public interface CadastrarDiarioEducacionalPortOut {

    public DiarioEducacionalDTO cadastrar(final DiarioEducacionalDTO diarioEducacionalDTO);
}