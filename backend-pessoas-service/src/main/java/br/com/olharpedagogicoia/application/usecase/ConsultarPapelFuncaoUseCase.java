package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.PapelFuncaoDTO;
import br.com.olharpedagogicoia.application.exceptions.PapelFuncaoNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.in.ConsultarPapelFuncaoPortIn;
import br.com.olharpedagogicoia.application.port.out.ConsultarPapelFuncaoPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class ConsultarPapelFuncaoUseCase implements ConsultarPapelFuncaoPortIn {

    final ConsultarPapelFuncaoPortOut consultarPapelFuncaoPortOut;

    @Override
    public PapelFuncaoDTO consultar(final Integer id) throws PapelFuncaoNaoEncontradoException {

        final PapelFuncaoDTO papelFuncaoDTO = consultarPapelFuncaoPortOut.consultar(id);

        log.info("Papel função consultado com sucesso: {}", papelFuncaoDTO);

        return papelFuncaoDTO;
    }
}