package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.dto.ResumoEducacionalDTO;

public interface AtualizarResumoEducacionalPortOut {

    public ResumoEducacionalDTO atualizar(final ResumoEducacionalDTO resumoEducacionalDTO);
}