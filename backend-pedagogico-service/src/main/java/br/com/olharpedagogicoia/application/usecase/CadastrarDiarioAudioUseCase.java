package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.DiarioAudioDTO;
import br.com.olharpedagogicoia.application.port.in.CadastrarDiarioAudioPortIn;
import br.com.olharpedagogicoia.application.port.out.CadastrarDiarioAudioPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
@AllArgsConstructor
public class CadastrarDiarioAudioUseCase implements CadastrarDiarioAudioPortIn {

    final CadastrarDiarioAudioPortOut cadastrarDiarioAudioPortOut;

    @Override
    public DiarioAudioDTO cadastrar(final DiarioAudioDTO diarioAudioDTO) {

        diarioAudioDTO.setDataCriacao(LocalDateTime.now());

        final DiarioAudioDTO diarioAudioCadastrado =
                cadastrarDiarioAudioPortOut.cadastrar(diarioAudioDTO);

        log.info("Diário áudio cadastrado com sucesso: {}", diarioAudioCadastrado);

        return diarioAudioCadastrado;
    }
}