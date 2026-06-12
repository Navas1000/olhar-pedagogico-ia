package br.com.olharpedagogicoia.adapters.out.diarioAudio;

import br.com.olharpedagogicoia.adapters.out.diarioAudio.entity.DiarioAudioEntity;
import br.com.olharpedagogicoia.adapters.out.diarioAudio.mapper.DiarioAudioMapper;
import br.com.olharpedagogicoia.adapters.out.diarioAudio.repository.DiarioAudioRepository;
import br.com.olharpedagogicoia.application.dto.DiarioAudioDTO;
import br.com.olharpedagogicoia.application.port.out.CadastrarDiarioAudioPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CadastrarDiarioAudioRepositoryAdapter implements CadastrarDiarioAudioPortOut {

    private final DiarioAudioRepository diarioAudioRepository;
    private final DiarioAudioMapper diarioAudioMapper;

    @Override
    public DiarioAudioDTO cadastrar(final DiarioAudioDTO diarioAudioDTO) {

        final DiarioAudioEntity diarioAudioEntity =
                diarioAudioMapper.deDiarioAudioDTOParaDiarioAudioEntity(diarioAudioDTO);

        final DiarioAudioEntity diarioAudioSalvo =
                diarioAudioRepository.save(diarioAudioEntity);

        return diarioAudioMapper.deDiarioAudioEntityParaDiarioAudioDTO(diarioAudioSalvo);
    }
}