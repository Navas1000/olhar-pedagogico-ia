package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.dto.ResumoEducacionalDTO;
import br.com.olharpedagogicoia.application.exceptions.ResumoEducacionalNaoEncontradoException;

public interface ConsultarResumoEducacionalPortOut {

    public ResumoEducacionalDTO consultar(final Integer id) throws ResumoEducacionalNaoEncontradoException;
}