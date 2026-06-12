package br.com.olharpedagogicoia.adapters.out.diarioEducacional;

import br.com.olharpedagogicoia.adapters.out.diarioEducacional.entity.DiarioEducacionalEntity;
import br.com.olharpedagogicoia.adapters.out.diarioEducacional.mapper.DiarioEducacionalMapper;
import br.com.olharpedagogicoia.adapters.out.diarioEducacional.repository.DiarioEducacionalRepository;
import br.com.olharpedagogicoia.application.dto.DiarioEducacionalDTO;
import br.com.olharpedagogicoia.application.port.out.CadastrarDiarioEducacionalPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CadastrarDiarioEducacionalRepositoryAdapter implements CadastrarDiarioEducacionalPortOut {

    private final DiarioEducacionalRepository diarioEducacionalRepository;
    private final DiarioEducacionalMapper diarioEducacionalMapper;

    @Override
    public DiarioEducacionalDTO cadastrar(final DiarioEducacionalDTO diarioEducacionalDTO) {

        final DiarioEducacionalEntity diarioEducacionalEntity =
                diarioEducacionalMapper.deDiarioEducacionalDTOParaDiarioEducacionalEntity(diarioEducacionalDTO);

        final DiarioEducacionalEntity diarioEducacionalSalvo =
                diarioEducacionalRepository.save(diarioEducacionalEntity);

        return diarioEducacionalMapper.deDiarioEducacionalEntityParaDiarioEducacionalDTO(diarioEducacionalSalvo);
    }
}