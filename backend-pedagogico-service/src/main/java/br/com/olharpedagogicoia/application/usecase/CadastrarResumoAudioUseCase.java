package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.ResumoAudioDTO;
import br.com.olharpedagogicoia.application.port.in.CadastrarResumoAudioPortIn;
import br.com.olharpedagogicoia.application.port.out.CadastrarResumoAudioPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
@AllArgsConstructor
public class CadastrarResumoAudioUseCase implements CadastrarResumoAudioPortIn {

    final CadastrarResumoAudioPortOut cadastrarResumoAudioPortOut;

    @Override
    public ResumoAudioDTO cadastrar(final ResumoAudioDTO resumoAudioDTO) {

        resumoAudioDTO.setDataCriacao(LocalDateTime.now());

        final ResumoAudioDTO resumoAudioCadastrado =
                cadastrarResumoAudioPortOut.cadastrar(resumoAudioDTO);

        log.info("Resumo áudio cadastrado com sucesso: {}", resumoAudioCadastrado);

        return resumoAudioCadastrado;
    }
}