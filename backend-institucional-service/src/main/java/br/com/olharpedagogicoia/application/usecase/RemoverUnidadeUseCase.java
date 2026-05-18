package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.exceptions.EmpresaNaoEncontradaException;
import br.com.olharpedagogicoia.application.exceptions.UnidadeNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.in.RemoverEmpresaPortIn;
import br.com.olharpedagogicoia.application.port.in.RemoverUnidadePortIn;
import br.com.olharpedagogicoia.application.port.out.RemoverEmpresaPortOut;
import br.com.olharpedagogicoia.application.port.out.RemoverUnidadePortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RemoverUnidadeUseCase implements RemoverUnidadePortIn {

    final RemoverUnidadePortOut removerUnidadePortOut;

    @Override
    public void remover(final Integer id) throws UnidadeNaoEncontradaException {

        removerUnidadePortOut.remover(id);

    }
}
