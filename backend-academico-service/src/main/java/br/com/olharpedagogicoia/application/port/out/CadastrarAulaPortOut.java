package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.dto.AulaDTO;

public interface CadastrarAulaPortOut {

    public AulaDTO cadastrar(final AulaDTO aulaDTO);

}