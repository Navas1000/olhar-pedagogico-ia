package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.exceptions.DiarioEducacionalNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.in.RemoverDiarioEducacionalPortIn;
import br.com.olharpedagogicoia.application.port.out.RemoverDiarioEducacionalPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class RemoverDiarioEducacionalUseCase implements RemoverDiarioEducacionalPortIn {

    final RemoverDiarioEducacionalPortOut removerDiarioEducacionalPortOut;

    @Override
    public void remover(final Integer id) throws DiarioEducacionalNaoEncontradoException {

        removerDiarioEducacionalPortOut.remover(id);

        log.info("Diário educacional removido com sucesso: {}", id);
    }
}