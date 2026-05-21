package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.exceptions.TurmaNaoEncontradaException;
import br.com.olharpedagogicoia.application.exceptions.UnidadeNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.in.RemoverTurmaPortIn;
import br.com.olharpedagogicoia.application.port.in.RemoverUnidadePortIn;
import br.com.olharpedagogicoia.application.port.out.RemoverTurmaPortOut;
import br.com.olharpedagogicoia.application.port.out.RemoverUnidadePortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RemoverTurmaUseCase implements RemoverTurmaPortIn {

    final RemoverTurmaPortOut removerTurmaPortOut;

    @Override
    public void remover(final Integer id) throws TurmaNaoEncontradaException {

        removerTurmaPortOut.remover(id);

    }
}
