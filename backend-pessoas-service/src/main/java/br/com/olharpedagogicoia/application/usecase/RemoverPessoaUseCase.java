package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.exceptions.PessoaNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.in.RemoverPessoaPortIn;
import br.com.olharpedagogicoia.application.port.out.RemoverPessoaPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class RemoverPessoaUseCase implements RemoverPessoaPortIn {

    final RemoverPessoaPortOut removerPessoaPortOut;

    @Override
    public void remover(final Integer id) throws PessoaNaoEncontradaException {

        removerPessoaPortOut.remover(id);

        log.info("Pessoa removida com sucesso: {}", id);
    }
}