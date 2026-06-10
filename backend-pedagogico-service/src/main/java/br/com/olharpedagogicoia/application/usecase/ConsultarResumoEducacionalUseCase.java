package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.ResumoEducacionalDTO;
import br.com.olharpedagogicoia.application.exceptions.ResumoEducacionalNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.in.ConsultarResumoEducacionalPortIn;
import br.com.olharpedagogicoia.application.port.out.ConsultarResumoEducacionalPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class ConsultarResumoEducacionalUseCase implements ConsultarResumoEducacionalPortIn {

    final ConsultarResumoEducacionalPortOut consultarResumoEducacionalPortOut;

    @Override
    public ResumoEducacionalDTO consultar(final Integer id) throws ResumoEducacionalNaoEncontradoException {

        final ResumoEducacionalDTO resumoEducacionalDTO = consultarResumoEducacionalPortOut.consultar(id);

        log.info("Resumo educacional consultado com sucesso: {}", resumoEducacionalDTO);

        return resumoEducacionalDTO;
    }
}