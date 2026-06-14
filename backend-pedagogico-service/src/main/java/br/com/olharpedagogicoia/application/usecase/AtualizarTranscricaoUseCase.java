package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.TranscricaoDTO;
import br.com.olharpedagogicoia.application.exceptions.Constantes;
import br.com.olharpedagogicoia.application.exceptions.IdTranscricaoObrigatorioException;
import br.com.olharpedagogicoia.application.exceptions.TranscricaoNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.in.AtualizarTranscricaoPortIn;
import br.com.olharpedagogicoia.application.port.out.AtualizarTranscricaoPortOut;
import br.com.olharpedagogicoia.application.port.out.ConsultarTranscricaoPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@Component
@AllArgsConstructor
public class AtualizarTranscricaoUseCase implements AtualizarTranscricaoPortIn {

    final AtualizarTranscricaoPortOut atualizarTranscricaoPortOut;
    final ConsultarTranscricaoPortOut consultarTranscricaoPortOut;

    @Override
    public TranscricaoDTO atualizar(final TranscricaoDTO transcricaoDTO)
            throws TranscricaoNaoEncontradaException, IdTranscricaoObrigatorioException {

        if (Objects.isNull(transcricaoDTO.getIdTranscricao()))
            throw new IdTranscricaoObrigatorioException(Constantes.ID_TRANSCRICAO_OBRIGATORIO);

        final TranscricaoDTO transcricaoConsultada =
                consultarTranscricaoPortOut.consultar(transcricaoDTO.getIdTranscricao());

        transcricaoDTO.setDataCriacao(transcricaoConsultada.getDataCriacao());

        final TranscricaoDTO transcricaoAtualizada =
                atualizarTranscricaoPortOut.atualizar(transcricaoDTO);

        log.info("Transcrição atualizada com sucesso: {}", transcricaoAtualizada);

        return transcricaoAtualizada;
    }
}