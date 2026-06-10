package br.com.olharpedagogicoia.adapters.out.diarioAudio;

import br.com.olharpedagogicoia.adapters.out.diarioAudio.entity.DiarioAudioEntity;
import br.com.olharpedagogicoia.adapters.out.diarioAudio.mapper.DiarioAudioMapper;
import br.com.olharpedagogicoia.adapters.out.diarioAudio.repository.DiarioAudioRepository;
import br.com.olharpedagogicoia.application.dto.DiarioAudioDTO;
import br.com.olharpedagogicoia.application.exceptions.Constantes;
import br.com.olharpedagogicoia.application.exceptions.DiarioAudioNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.out.ConsultarDiarioAudioPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ConsultarDiarioAudioRepositoryAdapter implements ConsultarDiarioAudioPortOut {

    private final DiarioAudioRepository diarioAudioRepository;
    private final DiarioAudioMapper diarioAudioMapper;

    @Override
    public DiarioAudioDTO consultar(final Integer id) throws DiarioAudioNaoEncontradoException {

        final Optional<DiarioAudioEntity> diarioAudioOpcional = diarioAudioRepository.findById(id);

        if (diarioAudioOpcional.isPresent())
            return diarioAudioMapper.deDiarioAudioEntityParaDiarioAudioDTO(diarioAudioOpcional.get());

        throw new DiarioAudioNaoEncontradoException(Constantes.DIARIO_AUDIO_NAO_ENCONTRADO);
    }
}