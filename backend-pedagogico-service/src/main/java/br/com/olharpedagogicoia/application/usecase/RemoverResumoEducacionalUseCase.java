package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.exceptions.ResumoEducacionalNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.in.RemoverResumoEducacionalPortIn;
import br.com.olharpedagogicoia.application.port.out.RemoverResumoEducacionalPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class RemoverResumoEducacionalUseCase implements RemoverResumoEducacionalPortIn {

    final RemoverResumoEducacionalPortOut removerResumoEducacionalPortOut;

    @Override
    public void remover(final Integer id) throws ResumoEducacionalNaoEncontradoException {

        removerResumoEducacionalPortOut.remover(id);

        log.info("Resumo educacional removido com sucesso: {}", id);
    }
}