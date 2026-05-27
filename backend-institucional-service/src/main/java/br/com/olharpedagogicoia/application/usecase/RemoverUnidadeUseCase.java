package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.exceptions.EmpresaNaoEncontradaException;
import br.com.olharpedagogicoia.application.exceptions.UnidadeNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.in.RemoverEmpresaPortIn;
import br.com.olharpedagogicoia.application.port.in.RemoverUnidadePortIn;
import br.com.olharpedagogicoia.application.port.out.RemoverEmpresaPortOut;
import br.com.olharpedagogicoia.application.port.out.RemoverUnidadePortOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class RemoverUnidadeUseCase implements RemoverUnidadePortIn {

    final RemoverUnidadePortOut removerUnidadePortOut;

    @Override
    public void remover(final Integer id) throws UnidadeNaoEncontradaException {

        log.info("Unidade removida com sucesso: {}", id);
        removerUnidadePortOut.remover(id);

    }
}
