package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.DiarioEducacionalDTO;
import br.com.olharpedagogicoia.application.exceptions.DiarioEducacionalNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.in.ConsultarDiarioEducacionalPortIn;
import br.com.olharpedagogicoia.application.port.out.ConsultarDiarioEducacionalPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class ConsultarDiarioEducacionalUseCase implements ConsultarDiarioEducacionalPortIn {

    final ConsultarDiarioEducacionalPortOut consultarDiarioEducacionalPortOut;

    @Override
    public DiarioEducacionalDTO consultar(final Integer id) throws DiarioEducacionalNaoEncontradoException {

        final DiarioEducacionalDTO diarioEducacionalDTO = consultarDiarioEducacionalPortOut.consultar(id);

        log.info("Diário educacional consultado com sucesso: {}", diarioEducacionalDTO);

        return diarioEducacionalDTO;
    }
}