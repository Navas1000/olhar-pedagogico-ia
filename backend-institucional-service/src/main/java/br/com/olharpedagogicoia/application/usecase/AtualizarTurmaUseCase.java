package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.TurmaDto;
import br.com.olharpedagogicoia.application.exceptions.Constantes;
import br.com.olharpedagogicoia.application.exceptions.IdTurmaObrigatorioException;
import br.com.olharpedagogicoia.application.exceptions.TurmaNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.in.AtualizarTurmaPortIn;
import br.com.olharpedagogicoia.application.port.out.AtualizarTurmaPortOut;
import br.com.olharpedagogicoia.application.port.out.ConsultarTurmaPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;

@Slf4j
@Component
@AllArgsConstructor
public class AtualizarTurmaUseCase implements AtualizarTurmaPortIn {

    final AtualizarTurmaPortOut atualizarTurmaPortOut;
    final ConsultarTurmaPortOut consultarTurmaPortOut;

    @Override
    public TurmaDto atualizar(final TurmaDto turmaDto)
            throws TurmaNaoEncontradaException, IdTurmaObrigatorioException {

        if (Objects.isNull(turmaDto.getIdTurma()))
            throw new IdTurmaObrigatorioException(Constantes.ID_TURMA_OBRIGATORIO);

        final TurmaDto turmaConsultada =
                consultarTurmaPortOut.consultar(turmaDto.getIdTurma());

        turmaDto.setDataCriacao(turmaConsultada.getDataCriacao());
        turmaDto.setDataModificacao(LocalDateTime.now());


        log.info("Turma atualizada com sucesso: {}", turmaConsultada);
        return atualizarTurmaPortOut.atualizar(turmaDto);

    }
}