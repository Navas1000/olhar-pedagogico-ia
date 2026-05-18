package br.com.olharpedagogicoia.adapters.out.unidade;

import br.com.olharpedagogicoia.adapters.out.unidade.entity.UnidadeEntity;
import br.com.olharpedagogicoia.adapters.out.unidade.mapper.UnidadeMapper;
import br.com.olharpedagogicoia.adapters.out.unidade.repository.UnidadeRepository;
import br.com.olharpedagogicoia.application.dto.UnidadeDto;
import br.com.olharpedagogicoia.application.exceptions.Constantes;
import br.com.olharpedagogicoia.application.exceptions.UnidadeNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.out.ConsultarUnidadePortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ConsultarUnidadeRepositoryAdapter implements ConsultarUnidadePortOut {

    private final UnidadeRepository unidadeRepository;
    private final UnidadeMapper unidadeMapper;

    public UnidadeDto consultar(final Integer id) throws UnidadeNaoEncontradaException {


        final Optional<UnidadeEntity> unidadeOpcional = unidadeRepository.findById(id);

        if (unidadeOpcional.isPresent())
            return unidadeMapper.deUnidadeEntityParaUnidadeDTO(unidadeOpcional.get());

        throw new UnidadeNaoEncontradaException(Constantes.UNIDADE_NAO_ENCONTRADA);

    }

}
