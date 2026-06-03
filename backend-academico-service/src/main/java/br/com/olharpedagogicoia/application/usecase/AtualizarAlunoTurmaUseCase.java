package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.AlunoTurmaDTO;
import br.com.olharpedagogicoia.application.exceptions.AlunoTurmaNaoEncontradaException;
import br.com.olharpedagogicoia.application.exceptions.Constantes;
import br.com.olharpedagogicoia.application.exceptions.IdAlunoTurmaObrigatorioException;
import br.com.olharpedagogicoia.application.port.in.AtualizarAlunoTurmaPortIn;
import br.com.olharpedagogicoia.application.port.out.AtualizarAlunoTurmaPortOut;
import br.com.olharpedagogicoia.application.port.out.ConsultarAlunoTurmaPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@Component
@AllArgsConstructor
public class AtualizarAlunoTurmaUseCase implements AtualizarAlunoTurmaPortIn {

    final AtualizarAlunoTurmaPortOut atualizarAlunoTurmaPortOut;
    final ConsultarAlunoTurmaPortOut consultarAlunoTurmaPortOut;

    @Override
    public AlunoTurmaDTO atualizar(final AlunoTurmaDTO alunoTurmaDTO)
            throws AlunoTurmaNaoEncontradaException, IdAlunoTurmaObrigatorioException {

        if (Objects.isNull(alunoTurmaDTO.getIdMatricula()))
            throw new IdAlunoTurmaObrigatorioException(Constantes.ID_ALUNO_TURMA_OBRIGATORIO);

        final AlunoTurmaDTO alunoTurmaConsultado =
                consultarAlunoTurmaPortOut.consultar(alunoTurmaDTO.getIdMatricula());

        alunoTurmaDTO.setDataCriacao(alunoTurmaConsultado.getDataCriacao());

        final AlunoTurmaDTO alunoTurmaAtualizado =
                atualizarAlunoTurmaPortOut.atualizar(alunoTurmaDTO);

        log.info("Aluno Turma atualizado com sucesso: {}", alunoTurmaAtualizado);

        return alunoTurmaAtualizado;
    }
}