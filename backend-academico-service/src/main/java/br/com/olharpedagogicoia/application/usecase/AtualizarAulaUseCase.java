package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.AulaDTO;
import br.com.olharpedagogicoia.application.exceptions.AulaNaoEncontradaException;
import br.com.olharpedagogicoia.application.exceptions.Constantes;
import br.com.olharpedagogicoia.application.exceptions.IdAulaObrigatorioException;
import br.com.olharpedagogicoia.application.port.in.AtualizarAulaPortIn;
import br.com.olharpedagogicoia.application.port.out.AtualizarAulaPortOut;
import br.com.olharpedagogicoia.application.port.out.ConsultarAulaPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@Component
@AllArgsConstructor
public class AtualizarAulaUseCase implements AtualizarAulaPortIn {

    final AtualizarAulaPortOut atualizarAulaPortOut;
    final ConsultarAulaPortOut consultarAulaPortOut;

    @Override
    public AulaDTO atualizar(final AulaDTO aulaDTO)
            throws AulaNaoEncontradaException, IdAulaObrigatorioException {

        if (Objects.isNull(aulaDTO.getIdAula()))
            throw new IdAulaObrigatorioException(Constantes.ID_AULA_OBRIGATORIO);

        final AulaDTO aulaConsultada = consultarAulaPortOut.consultar(aulaDTO.getIdAula());

        aulaDTO.setDataCriacao(aulaConsultada.getDataCriacao());

        final AulaDTO aulaAtualizada = atualizarAulaPortOut.atualizar(aulaDTO);

        log.info("Aula atualizada com sucesso: {}", aulaAtualizada);

        return aulaAtualizada;
    }
}