package br.com.olharpedagogicoia.adapters.out.transcricao;

import br.com.olharpedagogicoia.adapters.out.transcricao.entity.TranscricaoEntity;
import br.com.olharpedagogicoia.adapters.out.transcricao.mapper.TranscricaoMapper;
import br.com.olharpedagogicoia.adapters.out.transcricao.repository.TranscricaoRepository;
import br.com.olharpedagogicoia.application.dto.TranscricaoDTO;
import br.com.olharpedagogicoia.application.port.out.AtualizarTranscricaoPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AtualizarTranscricaoRepositoryAdapter implements AtualizarTranscricaoPortOut {

    private final TranscricaoRepository transcricaoRepository;
    private final TranscricaoMapper transcricaoMapper;

    @Override
    public TranscricaoDTO atualizar(final TranscricaoDTO transcricaoDTO) {

        final TranscricaoEntity transcricaoEntity =
                transcricaoMapper.deTranscricaoDTOParaTranscricaoEntity(transcricaoDTO);

        final TranscricaoEntity transcricaoSalva =
                transcricaoRepository.save(transcricaoEntity);

        return transcricaoMapper.deTranscricaoEntityParaTranscricaoDTO(transcricaoSalva);
    }
}