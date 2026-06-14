package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.dto.DiarioEducacionalDTO;

public interface AtualizarDiarioEducacionalPortOut {

    public DiarioEducacionalDTO atualizar(final DiarioEducacionalDTO diarioEducacionalDTO);
}