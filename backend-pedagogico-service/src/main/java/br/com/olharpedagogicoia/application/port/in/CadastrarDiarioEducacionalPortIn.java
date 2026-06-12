package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.dto.DiarioEducacionalDTO;

public interface CadastrarDiarioEducacionalPortIn {

    public DiarioEducacionalDTO cadastrar(final DiarioEducacionalDTO diarioEducacionalDTO);
}