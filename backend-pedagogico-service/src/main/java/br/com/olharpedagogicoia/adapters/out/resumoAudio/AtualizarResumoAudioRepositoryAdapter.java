package br.com.olharpedagogicoia.adapters.out.resumoAudio;

import br.com.olharpedagogicoia.adapters.out.resumoAudio.entity.ResumoAudioEntity;
import br.com.olharpedagogicoia.adapters.out.resumoAudio.mapper.ResumoAudioMapper;
import br.com.olharpedagogicoia.adapters.out.resumoAudio.repository.ResumoAudioRepository;
import br.com.olharpedagogicoia.application.dto.ResumoAudioDTO;
import br.com.olharpedagogicoia.application.port.out.AtualizarResumoAudioPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AtualizarResumoAudioRepositoryAdapter implements AtualizarResumoAudioPortOut {

    private final ResumoAudioRepository resumoAudioRepository;
    private final ResumoAudioMapper resumoAudioMapper;

    @Override
    public ResumoAudioDTO atualizar(final ResumoAudioDTO resumoAudioDTO) {

        final ResumoAudioEntity resumoAudioEntity =
                resumoAudioMapper.deResumoAudioDTOParaResumoAudioEntity(resumoAudioDTO);

        final ResumoAudioEntity resumoAudioSalvo =
                resumoAudioRepository.save(resumoAudioEntity);

        return resumoAudioMapper.deResumoAudioEntityParaResumoAudioDTO(resumoAudioSalvo);
    }
}