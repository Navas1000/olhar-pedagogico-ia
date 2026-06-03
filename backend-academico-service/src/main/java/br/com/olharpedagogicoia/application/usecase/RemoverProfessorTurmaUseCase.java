package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.exceptions.ProfessorTurmaNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.in.RemoverProfessorTurmaPortIn;
import br.com.olharpedagogicoia.application.port.out.RemoverProfessorTurmaPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class RemoverProfessorTurmaUseCase implements RemoverProfessorTurmaPortIn {

    final RemoverProfessorTurmaPortOut removerProfessorTurmaPortOut;

    @Override
    public void remover(final Integer id) throws ProfessorTurmaNaoEncontradaException {

        removerProfessorTurmaPortOut.remover(id);

        log.info("Professor Turma removido com sucesso: {}", id);
    }
}