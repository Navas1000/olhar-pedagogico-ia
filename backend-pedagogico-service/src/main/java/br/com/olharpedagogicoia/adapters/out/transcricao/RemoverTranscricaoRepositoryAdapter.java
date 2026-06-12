package br.com.olharpedagogicoia.adapters.out.transcricao;

import br.com.olharpedagogicoia.adapters.out.transcricao.entity.TranscricaoEntity;
import br.com.olharpedagogicoia.adapters.out.transcricao.repository.TranscricaoRepository;
import br.com.olharpedagogicoia.application.exceptions.Constantes;
import br.com.olharpedagogicoia.application.exceptions.TranscricaoNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.out.RemoverTranscricaoPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RemoverTranscricaoRepositoryAdapter implements RemoverTranscricaoPortOut {

    private final TranscricaoRepository transcricaoRepository;

    @Override
    public void remover(final Integer id) throws TranscricaoNaoEncontradaException {

        final Optional<TranscricaoEntity> transcricaoOpcional = transcricaoRepository.findById(id);

        if (transcricaoOpcional.isPresent())
            transcricaoRepository.deleteById(id);
        else
            throw new TranscricaoNaoEncontradaException(Constantes.TRANSCRICAO_NAO_ENCONTRADA);
    }
}