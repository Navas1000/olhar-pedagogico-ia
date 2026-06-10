package br.com.olharpedagogicoia.adapters.out.resumoEducacional;

import br.com.olharpedagogicoia.adapters.out.resumoEducacional.entity.ResumoEducacionalEntity;
import br.com.olharpedagogicoia.adapters.out.resumoEducacional.mapper.ResumoEducacionalMapper;
import br.com.olharpedagogicoia.adapters.out.resumoEducacional.repository.ResumoEducacionalRepository;
import br.com.olharpedagogicoia.application.dto.ResumoEducacionalDTO;
import br.com.olharpedagogicoia.application.exceptions.Constantes;
import br.com.olharpedagogicoia.application.exceptions.ResumoEducacionalNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.out.ConsultarResumoEducacionalPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ConsultarResumoEducacionalRepositoryAdapter implements ConsultarResumoEducacionalPortOut {

    private final ResumoEducacionalRepository resumoEducacionalRepository;
    private final ResumoEducacionalMapper resumoEducacionalMapper;

    @Override
    public ResumoEducacionalDTO consultar(final Integer id) throws ResumoEducacionalNaoEncontradoException {

        final Optional<ResumoEducacionalEntity> resumoEducacionalOpcional =
                resumoEducacionalRepository.findById(id);

        if (resumoEducacionalOpcional.isPresent())
            return resumoEducacionalMapper.deResumoEducacionalEntityParaResumoEducacionalDTO(
                    resumoEducacionalOpcional.get()
            );

        throw new ResumoEducacionalNaoEncontradoException(Constantes.RESUMO_EDUCACIONAL_NAO_ENCONTRADO);
    }
}