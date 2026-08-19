package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.dto.AulaDTO;

import java.util.List;

public interface ConsultarAulaPorAlocacaoPortOut {

    List<AulaDTO> consultarPorAlocacao(final Integer idAlocacao);

}