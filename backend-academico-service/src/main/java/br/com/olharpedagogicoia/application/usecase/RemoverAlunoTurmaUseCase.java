package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.exceptions.AlunoTurmaNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.in.RemoverAlunoTurmaPortIn;
import br.com.olharpedagogicoia.application.port.out.RemoverAlunoTurmaPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class RemoverAlunoTurmaUseCase implements RemoverAlunoTurmaPortIn {

    final RemoverAlunoTurmaPortOut removerAlunoTurmaPortOut;

    @Override
    public void remover(final Integer id) throws AlunoTurmaNaoEncontradaException {

        removerAlunoTurmaPortOut.remover(id);

        log.info("Aluno Turma removido com sucesso: {}", id);
    }
}