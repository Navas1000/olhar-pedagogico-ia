package br.com.olharpedagogicoia.adapters.out.resumoAudio;

import br.com.olharpedagogicoia.adapters.out.resumoAudio.entity.ResumoAudioEntity;
import br.com.olharpedagogicoia.adapters.out.resumoAudio.mapper.ResumoAudioMapper;
import br.com.olharpedagogicoia.adapters.out.resumoAudio.repository.ResumoAudioRepository;
import br.com.olharpedagogicoia.application.dto.ResumoAudioDTO;
import br.com.olharpedagogicoia.application.exceptions.Constantes;
import br.com.olharpedagogicoia.application.exceptions.ResumoAudioNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.out.ConsultarResumoAudioPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ConsultarResumoAudioRepositoryAdapter implements ConsultarResumoAudioPortOut {

    private final ResumoAudioRepository resumoAudioRepository;
    private final ResumoAudioMapper resumoAudioMapper;

    @Override
    public ResumoAudioDTO consultar(final Integer id) throws ResumoAudioNaoEncontradoException {

        final Optional<ResumoAudioEntity> resumoAudioOpcional = resumoAudioRepository.findById(id);

        if (resumoAudioOpcional.isPresent())
            return resumoAudioMapper.deResumoAudioEntityParaResumoAudioDTO(resumoAudioOpcional.get());

        throw new ResumoAudioNaoEncontradoException(Constantes.RESUMO_AUDIO_NAO_ENCONTRADO);
    }
}