package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.dto.ResumoEducacionalDTO;

public interface CadastrarResumoEducacionalPortIn {

    public ResumoEducacionalDTO cadastrar(final ResumoEducacionalDTO resumoEducacionalDTO);
}