package br.com.olharpedagogicoia.adapters.out.unidade;

import br.com.olharpedagogicoia.adapters.out.empresa.entity.EmpresaEntity;
import br.com.olharpedagogicoia.adapters.out.empresa.mapper.EmpresaMapper;
import br.com.olharpedagogicoia.adapters.out.empresa.repository.EmpresaRepository;
import br.com.olharpedagogicoia.adapters.out.unidade.entity.UnidadeEntity;
import br.com.olharpedagogicoia.adapters.out.unidade.mapper.UnidadeMapper;
import br.com.olharpedagogicoia.adapters.out.unidade.repository.UnidadeRepository;
import br.com.olharpedagogicoia.application.dto.EmpresaDto;
import br.com.olharpedagogicoia.application.dto.UnidadeDto;
import br.com.olharpedagogicoia.application.port.out.AtualizarEmpresaPortOut;
import br.com.olharpedagogicoia.application.port.out.AtualizarUnidadePortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AtualizarUnidadeRepositoryAdapter implements AtualizarUnidadePortOut {

    private final UnidadeRepository unidadeRepository;
    private final UnidadeMapper unidadeMapper;

    @Override
    public UnidadeDto atualizar(final UnidadeDto unidadeDto) {

        final UnidadeEntity unidadeEntity =
                unidadeMapper.deUnidadeDTOParaUnidadeEntity(unidadeDto);

        final UnidadeEntity unidadeSalva =
                unidadeRepository.save(unidadeEntity);

        return unidadeMapper.deUnidadeEntityParaUnidadeDTO(unidadeSalva);

    }

}
