package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.DiarioAudioDTO;
import br.com.olharpedagogicoia.application.exceptions.Constantes;
import br.com.olharpedagogicoia.application.exceptions.DiarioAudioNaoEncontradoException;
import br.com.olharpedagogicoia.application.exceptions.IdDiarioAudioObrigatorioException;
import br.com.olharpedagogicoia.application.port.in.AtualizarDiarioAudioPortIn;
import br.com.olharpedagogicoia.application.port.out.AtualizarDiarioAudioPortOut;
import br.com.olharpedagogicoia.application.port.out.ConsultarDiarioAudioPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@Component
@AllArgsConstructor
public class AtualizarDiarioAudioUseCase implements AtualizarDiarioAudioPortIn {

    final AtualizarDiarioAudioPortOut atualizarDiarioAudioPortOut;
    final ConsultarDiarioAudioPortOut consultarDiarioAudioPortOut;

    @Override
    public DiarioAudioDTO atualizar(final DiarioAudioDTO diarioAudioDTO)
            throws DiarioAudioNaoEncontradoException, IdDiarioAudioObrigatorioException {

        if (Objects.isNull(diarioAudioDTO.getIdAudio()))
            throw new IdDiarioAudioObrigatorioException(Constantes.ID_DIARIO_AUDIO_OBRIGATORIO);

        final DiarioAudioDTO diarioAudioConsultado =
                consultarDiarioAudioPortOut.consultar(diarioAudioDTO.getIdAudio());

        diarioAudioDTO.setDataCriacao(diarioAudioConsultado.getDataCriacao());

        final DiarioAudioDTO diarioAudioAtualizado =
                atualizarDiarioAudioPortOut.atualizar(diarioAudioDTO);

        log.info("Diário áudio atualizado com sucesso: {}", diarioAudioAtualizado);

        return diarioAudioAtualizado;
    }
}