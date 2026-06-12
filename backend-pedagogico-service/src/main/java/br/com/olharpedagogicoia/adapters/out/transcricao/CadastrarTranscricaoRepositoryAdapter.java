package br.com.olharpedagogicoia.adapters.out.transcricao;

import br.com.olharpedagogicoia.adapters.out.transcricao.entity.TranscricaoEntity;
import br.com.olharpedagogicoia.adapters.out.transcricao.mapper.TranscricaoMapper;
import br.com.olharpedagogicoia.adapters.out.transcricao.repository.TranscricaoRepository;
import br.com.olharpedagogicoia.application.dto.TranscricaoDTO;
import br.com.olharpedagogicoia.application.port.out.CadastrarTranscricaoPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CadastrarTranscricaoRepositoryAdapter implements CadastrarTranscricaoPortOut {

    private final TranscricaoRepository transcricaoRepository;
    private final TranscricaoMapper transcricaoMapper;

    @Override
    public TranscricaoDTO cadastrar(final TranscricaoDTO transcricaoDTO) {

        final TranscricaoEntity transcricaoEntity =
                transcricaoMapper.deTranscricaoDTOParaTranscricaoEntity(transcricaoDTO);

        final TranscricaoEntity transcricaoSalva =
                transcricaoRepository.save(transcricaoEntity);

        return transcricaoMapper.deTranscricaoEntityParaTranscricaoDTO(transcricaoSalva);
    }
}