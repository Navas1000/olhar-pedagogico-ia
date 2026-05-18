package br.com.olharpedagogicoia.adapters.out.unidade;

import br.com.olharpedagogicoia.adapters.out.unidade.entity.UnidadeEntity;
import br.com.olharpedagogicoia.adapters.out.unidade.mapper.UnidadeMapper;
import br.com.olharpedagogicoia.adapters.out.unidade.repository.UnidadeRepository;
import br.com.olharpedagogicoia.application.dto.UnidadeDto;
import br.com.olharpedagogicoia.application.port.out.CadastrarUnidadePortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CadastrarUnidadeRepositoryAdapter implements CadastrarUnidadePortOut {

    private final UnidadeRepository unidadeRepository;
    private final UnidadeMapper unidadeMapper;

    @Override
    public UnidadeDto cadastrar(UnidadeDto unidadeDto) {

        final UnidadeEntity unidadeEntity =
                unidadeMapper.deUnidadeDTOParaUnidadeEntity(unidadeDto);

        final UnidadeEntity unidadeSalva =
                unidadeRepository.save(unidadeEntity);

        return unidadeMapper.deUnidadeEntityParaUnidadeDTO(unidadeSalva);

    }

}
