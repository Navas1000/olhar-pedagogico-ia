package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.AulaDTO;
import br.com.olharpedagogicoia.application.port.in.ConsultarAulaPorAlocacaoPortIn;
import br.com.olharpedagogicoia.application.port.out.ConsultarAulaPorAlocacaoPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ConsultarAulaPorAlocacaoUseCase
        implements ConsultarAulaPorAlocacaoPortIn {

    private final ConsultarAulaPorAlocacaoPortOut
            consultarAulaPorAlocacaoPortOut;

    @Override
    public List<AulaDTO> consultarPorAlocacao(
            final Integer idAlocacao) {

        return consultarAulaPorAlocacaoPortOut
                .consultarPorAlocacao(idAlocacao);
    }
}