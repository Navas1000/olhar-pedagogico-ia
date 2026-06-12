package br.com.olharpedagogicoia.adapters.out.resumoAudio;

import br.com.olharpedagogicoia.adapters.out.resumoAudio.entity.ResumoAudioEntity;
import br.com.olharpedagogicoia.adapters.out.resumoAudio.repository.ResumoAudioRepository;
import br.com.olharpedagogicoia.application.exceptions.Constantes;
import br.com.olharpedagogicoia.application.exceptions.ResumoAudioNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.out.RemoverResumoAudioPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RemoverResumoAudioRepositoryAdapter implements RemoverResumoAudioPortOut {

    private final ResumoAudioRepository resumoAudioRepository;

    @Override
    public void remover(final Integer id) throws ResumoAudioNaoEncontradoException {

        final Optional<ResumoAudioEntity> resumoAudioOpcional = resumoAudioRepository.findById(id);

        if (resumoAudioOpcional.isPresent())
            resumoAudioRepository.deleteById(id);
        else
            throw new ResumoAudioNaoEncontradoException(Constantes.RESUMO_AUDIO_NAO_ENCONTRADO);
    }
}