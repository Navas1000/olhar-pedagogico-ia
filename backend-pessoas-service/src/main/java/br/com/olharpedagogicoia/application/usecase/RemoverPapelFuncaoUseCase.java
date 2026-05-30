package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.exceptions.PapelFuncaoNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.in.RemoverPapelFuncaoPortIn;
import br.com.olharpedagogicoia.application.port.out.RemoverPapelFuncaoPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class RemoverPapelFuncaoUseCase implements RemoverPapelFuncaoPortIn {

    final RemoverPapelFuncaoPortOut removerPapelFuncaoPortOut;

    @Override
    public void remover(final Integer id) throws PapelFuncaoNaoEncontradoException {

        removerPapelFuncaoPortOut.remover(id);

        log.info("Papel Função removido com sucesso: {}", id);
    }
}