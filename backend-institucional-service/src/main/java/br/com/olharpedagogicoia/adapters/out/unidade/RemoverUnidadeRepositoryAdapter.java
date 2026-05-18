package br.com.olharpedagogicoia.adapters.out.unidade;

import br.com.olharpedagogicoia.adapters.out.unidade.entity.UnidadeEntity;
import br.com.olharpedagogicoia.adapters.out.unidade.repository.UnidadeRepository;
import br.com.olharpedagogicoia.application.exceptions.Constantes;
import br.com.olharpedagogicoia.application.exceptions.UnidadeNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.out.RemoverUnidadePortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RemoverUnidadeRepositoryAdapter implements RemoverUnidadePortOut {

    private final UnidadeRepository unidadeRepository;

    public void remover(final Integer id) throws UnidadeNaoEncontradaException {


        final Optional<UnidadeEntity> unidadeOpcional = unidadeRepository.findById(id);

        if (unidadeOpcional.isPresent())
            unidadeRepository.deleteById(id);

        else
            throw new UnidadeNaoEncontradaException(Constantes.UNIDADE_NAO_ENCONTRADA);

    }

}
