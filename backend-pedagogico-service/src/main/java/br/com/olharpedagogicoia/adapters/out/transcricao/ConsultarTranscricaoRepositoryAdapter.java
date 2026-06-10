package br.com.olharpedagogicoia.adapters.out.transcricao;

import br.com.olharpedagogicoia.adapters.out.transcricao.entity.TranscricaoEntity;
import br.com.olharpedagogicoia.adapters.out.transcricao.mapper.TranscricaoMapper;
import br.com.olharpedagogicoia.adapters.out.transcricao.repository.TranscricaoRepository;
import br.com.olharpedagogicoia.application.dto.TranscricaoDTO;
import br.com.olharpedagogicoia.application.exceptions.Constantes;
import br.com.olharpedagogicoia.application.exceptions.TranscricaoNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.out.ConsultarTranscricaoPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ConsultarTranscricaoRepositoryAdapter implements ConsultarTranscricaoPortOut {

    private final TranscricaoRepository transcricaoRepository;
    private final TranscricaoMapper transcricaoMapper;

    @Override
    public TranscricaoDTO consultar(final Integer id) throws TranscricaoNaoEncontradaException {

        final Optional<TranscricaoEntity> transcricaoOpcional = transcricaoRepository.findById(id);

        if (transcricaoOpcional.isPresent())
            return transcricaoMapper.deTranscricaoEntityParaTranscricaoDTO(transcricaoOpcional.get());

        throw new TranscricaoNaoEncontradaException(Constantes.TRANSCRICAO_NAO_ENCONTRADA);
    }
}