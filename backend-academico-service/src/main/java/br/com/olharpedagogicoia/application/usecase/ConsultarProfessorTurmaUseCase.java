package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.ProfessorTurmaDTO;
import br.com.olharpedagogicoia.application.exceptions.ProfessorTurmaNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.in.ConsultarProfessorTurmaPortIn;
import br.com.olharpedagogicoia.application.port.out.ConsultarProfessorTurmaPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class ConsultarProfessorTurmaUseCase implements ConsultarProfessorTurmaPortIn {

    final ConsultarProfessorTurmaPortOut consultarProfessorTurmaPortOut;

    @Override
    public ProfessorTurmaDTO consultar(final Integer id) throws ProfessorTurmaNaoEncontradaException {

        final ProfessorTurmaDTO professorTurmaDTO = consultarProfessorTurmaPortOut.consultar(id);

        log.info("Professor Turma consultado com sucesso: {}", professorTurmaDTO);

        return professorTurmaDTO;
    }
}