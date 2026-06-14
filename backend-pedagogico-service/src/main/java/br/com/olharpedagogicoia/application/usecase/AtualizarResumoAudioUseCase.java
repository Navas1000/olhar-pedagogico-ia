package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.ResumoAudioDTO;
import br.com.olharpedagogicoia.application.exceptions.Constantes;
import br.com.olharpedagogicoia.application.exceptions.IdResumoAudioObrigatorioException;
import br.com.olharpedagogicoia.application.exceptions.ResumoAudioNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.in.AtualizarResumoAudioPortIn;
import br.com.olharpedagogicoia.application.port.out.AtualizarResumoAudioPortOut;
import br.com.olharpedagogicoia.application.port.out.ConsultarResumoAudioPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@Component
@AllArgsConstructor
public class AtualizarResumoAudioUseCase implements AtualizarResumoAudioPortIn {

    final AtualizarResumoAudioPortOut atualizarResumoAudioPortOut;
    final ConsultarResumoAudioPortOut consultarResumoAudioPortOut;

    @Override
    public ResumoAudioDTO atualizar(final ResumoAudioDTO resumoAudioDTO)
            throws ResumoAudioNaoEncontradoException, IdResumoAudioObrigatorioException {

        if (Objects.isNull(resumoAudioDTO.getIdAudio()))
            throw new IdResumoAudioObrigatorioException(Constantes.ID_RESUMO_AUDIO_OBRIGATORIO);

        final ResumoAudioDTO resumoAudioConsultado =
                consultarResumoAudioPortOut.consultar(resumoAudioDTO.getIdAudio());

        resumoAudioDTO.setDataCriacao(resumoAudioConsultado.getDataCriacao());

        final ResumoAudioDTO resumoAudioAtualizado =
                atualizarResumoAudioPortOut.atualizar(resumoAudioDTO);

        log.info("Resumo áudio atualizado com sucesso: {}", resumoAudioAtualizado);

        return resumoAudioAtualizado;
    }
}