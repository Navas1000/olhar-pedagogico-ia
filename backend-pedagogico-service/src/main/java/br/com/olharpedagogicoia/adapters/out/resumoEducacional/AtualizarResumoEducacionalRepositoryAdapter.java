package br.com.olharpedagogicoia.adapters.out.resumoEducacional;

import br.com.olharpedagogicoia.adapters.out.resumoEducacional.entity.ResumoEducacionalEntity;
import br.com.olharpedagogicoia.adapters.out.resumoEducacional.mapper.ResumoEducacionalMapper;
import br.com.olharpedagogicoia.adapters.out.resumoEducacional.repository.ResumoEducacionalRepository;
import br.com.olharpedagogicoia.application.dto.ResumoEducacionalDTO;
import br.com.olharpedagogicoia.application.port.out.AtualizarResumoEducacionalPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AtualizarResumoEducacionalRepositoryAdapter implements AtualizarResumoEducacionalPortOut {

    private final ResumoEducacionalRepository resumoEducacionalRepository;
    private final ResumoEducacionalMapper resumoEducacionalMapper;

    @Override
    public ResumoEducacionalDTO atualizar(final ResumoEducacionalDTO resumoEducacionalDTO) {

        final ResumoEducacionalEntity resumoEducacionalEntity =
                resumoEducacionalMapper.deResumoEducacionalDTOParaResumoEducacionalEntity(resumoEducacionalDTO);

        final ResumoEducacionalEntity resumoEducacionalSalvo =
                resumoEducacionalRepository.save(resumoEducacionalEntity);

        return resumoEducacionalMapper.deResumoEducacionalEntityParaResumoEducacionalDTO(resumoEducacionalSalvo);
    }
}