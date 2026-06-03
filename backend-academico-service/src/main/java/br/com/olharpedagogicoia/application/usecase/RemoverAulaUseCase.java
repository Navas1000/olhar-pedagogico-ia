package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.exceptions.AulaNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.in.RemoverAulaPortIn;
import br.com.olharpedagogicoia.application.port.out.RemoverAulaPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class RemoverAulaUseCase implements RemoverAulaPortIn {

    final RemoverAulaPortOut removerAulaPortOut;

    @Override
    public void remover(final Integer id) throws AulaNaoEncontradaException {

        removerAulaPortOut.remover(id);

        log.info("Aula removida com sucesso: {}", id);
    }
}