package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.exceptions.FuncionarioNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.in.RemoverFuncionarioPortIn;
import br.com.olharpedagogicoia.application.port.out.RemoverFuncionarioPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class RemoverFuncionarioUseCase implements RemoverFuncionarioPortIn {

    final RemoverFuncionarioPortOut removerFuncionarioPortOut;

    @Override
    public void remover(final Integer id) throws FuncionarioNaoEncontradoException {

        removerFuncionarioPortOut.remover(id);

        log.info("Funcionário removido com sucesso: {}", id);
    }
}