package br.com.olharpedagogicoia.adapters.out.diarioAudio;

import br.com.olharpedagogicoia.adapters.out.diarioAudio.entity.DiarioAudioEntity;
import br.com.olharpedagogicoia.adapters.out.diarioAudio.repository.DiarioAudioRepository;
import br.com.olharpedagogicoia.application.exceptions.Constantes;
import br.com.olharpedagogicoia.application.exceptions.DiarioAudioNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.out.RemoverDiarioAudioPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RemoverDiarioAudioRepositoryAdapter implements RemoverDiarioAudioPortOut {

    private final DiarioAudioRepository diarioAudioRepository;

    @Override
    public void remover(final Integer id) throws DiarioAudioNaoEncontradoException {

        final Optional<DiarioAudioEntity> diarioAudioOpcional = diarioAudioRepository.findById(id);

        if (diarioAudioOpcional.isPresent())
            diarioAudioRepository.deleteById(id);
        else
            throw new DiarioAudioNaoEncontradoException(Constantes.DIARIO_AUDIO_NAO_ENCONTRADO);
    }
}