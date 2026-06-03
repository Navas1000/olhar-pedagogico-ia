package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.AlunoTurmaDTO;
import br.com.olharpedagogicoia.application.exceptions.AlunoTurmaNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.in.ConsultarAlunoTurmaPortIn;
import br.com.olharpedagogicoia.application.port.out.ConsultarAlunoTurmaPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class ConsultarAlunoTurmaUseCase implements ConsultarAlunoTurmaPortIn {

    final ConsultarAlunoTurmaPortOut consultarAlunoTurmaPortOut;

    @Override
    public AlunoTurmaDTO consultar(final Integer id) throws AlunoTurmaNaoEncontradaException {

        final AlunoTurmaDTO alunoTurmaDTO = consultarAlunoTurmaPortOut.consultar(id);

        log.info("Aluno Turma consultado com sucesso: {}", alunoTurmaDTO);

        return alunoTurmaDTO;
    }
}