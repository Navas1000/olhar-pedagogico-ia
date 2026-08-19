package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.dto.AulaDTO;

import java.util.List;

public interface ConsultarAulaPorAlocacaoPortIn {

    List<AulaDTO> consultarPorAlocacao(final Integer idAlocacao);

}