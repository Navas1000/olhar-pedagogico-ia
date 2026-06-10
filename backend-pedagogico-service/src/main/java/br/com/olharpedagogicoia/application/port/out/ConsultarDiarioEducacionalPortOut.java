package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.dto.DiarioEducacionalDTO;
import br.com.olharpedagogicoia.application.exceptions.DiarioEducacionalNaoEncontradoException;

public interface ConsultarDiarioEducacionalPortOut {

    public DiarioEducacionalDTO consultar(final Integer id) throws DiarioEducacionalNaoEncontradoException;
}