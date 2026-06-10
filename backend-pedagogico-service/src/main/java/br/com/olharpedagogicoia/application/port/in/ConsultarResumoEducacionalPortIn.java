package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.dto.ResumoEducacionalDTO;
import br.com.olharpedagogicoia.application.exceptions.ResumoEducacionalNaoEncontradoException;

public interface ConsultarResumoEducacionalPortIn {

    public ResumoEducacionalDTO consultar(final Integer id) throws ResumoEducacionalNaoEncontradoException;
}