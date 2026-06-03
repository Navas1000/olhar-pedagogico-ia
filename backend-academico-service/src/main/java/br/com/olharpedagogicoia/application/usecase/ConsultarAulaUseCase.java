package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.AulaDTO;
import br.com.olharpedagogicoia.application.exceptions.AulaNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.in.ConsultarAulaPortIn;
import br.com.olharpedagogicoia.application.port.out.ConsultarAulaPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class ConsultarAulaUseCase implements ConsultarAulaPortIn {

    final ConsultarAulaPortOut consultarAulaPortOut;

    @Override
    public AulaDTO consultar(final Integer id) throws AulaNaoEncontradaException {

        final AulaDTO aulaDTO = consultarAulaPortOut.consultar(id);

        log.info("Aula consultada com sucesso: {}", aulaDTO);

        return aulaDTO;
    }
}