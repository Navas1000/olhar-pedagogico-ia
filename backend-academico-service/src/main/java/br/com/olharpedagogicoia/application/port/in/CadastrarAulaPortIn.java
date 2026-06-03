package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.dto.AulaDTO;

public interface CadastrarAulaPortIn {

    public AulaDTO cadastrar(final AulaDTO aulaDTO);

}