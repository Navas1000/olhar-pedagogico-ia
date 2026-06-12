package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.dto.ResumoEducacionalDTO;

public interface CadastrarResumoEducacionalPortOut {

    public ResumoEducacionalDTO cadastrar(final ResumoEducacionalDTO resumoEducacionalDTO);
}