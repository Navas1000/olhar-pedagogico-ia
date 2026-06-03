package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.ProfessorTurmaDTO;
import br.com.olharpedagogicoia.application.exceptions.Constantes;
import br.com.olharpedagogicoia.application.exceptions.IdProfessorTurmaObrigatorioException;
import br.com.olharpedagogicoia.application.exceptions.ProfessorTurmaNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.in.AtualizarProfessorTurmaPortIn;
import br.com.olharpedagogicoia.application.port.out.AtualizarProfessorTurmaPortOut;
import br.com.olharpedagogicoia.application.port.out.ConsultarProfessorTurmaPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@Component
@AllArgsConstructor
public class AtualizarProfessorTurmaUseCase implements AtualizarProfessorTurmaPortIn {

    final AtualizarProfessorTurmaPortOut atualizarProfessorTurmaPortOut;
    final ConsultarProfessorTurmaPortOut consultarProfessorTurmaPortOut;

    @Override
    public ProfessorTurmaDTO atualizar(final ProfessorTurmaDTO professorTurmaDTO)
            throws ProfessorTurmaNaoEncontradaException, IdProfessorTurmaObrigatorioException {

        if (Objects.isNull(professorTurmaDTO.getIdAlocacao()))
            throw new IdProfessorTurmaObrigatorioException(Constantes.ID_PROFESSOR_TURMA_OBRIGATORIO);

        final ProfessorTurmaDTO professorTurmaConsultado =
                consultarProfessorTurmaPortOut.consultar(professorTurmaDTO.getIdAlocacao());

        professorTurmaDTO.setDataCriacao(professorTurmaConsultado.getDataCriacao());

        final ProfessorTurmaDTO professorTurmaAtualizado =
                atualizarProfessorTurmaPortOut.atualizar(professorTurmaDTO);

        log.info("Professor Turma atualizado com sucesso: {}", professorTurmaAtualizado);

        return professorTurmaAtualizado;
    }
}