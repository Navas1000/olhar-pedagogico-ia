package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.exceptions.TurmaNaoEncontradaException;
import br.com.olharpedagogicoia.application.exceptions.UnidadeNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.in.RemoverTurmaPortIn;
import br.com.olharpedagogicoia.application.port.in.RemoverUnidadePortIn;
import br.com.olharpedagogicoia.application.port.out.RemoverTurmaPortOut;
import br.com.olharpedagogicoia.application.port.out.RemoverUnidadePortOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class RemoverTurmaUseCase implements RemoverTurmaPortIn {

    final RemoverTurmaPortOut removerTurmaPortOut;

    @Override
    public void remover(final Integer id) throws TurmaNaoEncontradaException {

        log.info("Turma removida com sucesso: {}", id);
        removerTurmaPortOut.remover(id);

    }
}
