package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.exceptions.AlunoNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.in.RemoverAlunoPortIn;
import br.com.olharpedagogicoia.application.port.out.RemoverAlunoPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class RemoverAlunoUseCase implements RemoverAlunoPortIn {

    final RemoverAlunoPortOut removerAlunoPortOut;

    @Override
    public void remover(final Integer id) throws AlunoNaoEncontradoException {

        removerAlunoPortOut.remover(id);

        log.info("Aluno removido com sucesso: {}", id);
    }
}