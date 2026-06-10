package br.com.olharpedagogicoia.adapters.out.diarioEducacional;

import br.com.olharpedagogicoia.adapters.out.diarioEducacional.entity.DiarioEducacionalEntity;
import br.com.olharpedagogicoia.adapters.out.diarioEducacional.mapper.DiarioEducacionalMapper;
import br.com.olharpedagogicoia.adapters.out.diarioEducacional.repository.DiarioEducacionalRepository;
import br.com.olharpedagogicoia.application.dto.DiarioEducacionalDTO;
import br.com.olharpedagogicoia.application.exceptions.Constantes;
import br.com.olharpedagogicoia.application.exceptions.DiarioEducacionalNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.out.ConsultarDiarioEducacionalPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ConsultarDiarioEducacionalRepositoryAdapter implements ConsultarDiarioEducacionalPortOut {

    private final DiarioEducacionalRepository diarioEducacionalRepository;
    private final DiarioEducacionalMapper diarioEducacionalMapper;

    @Override
    public DiarioEducacionalDTO consultar(final Integer id) throws DiarioEducacionalNaoEncontradoException {

        final Optional<DiarioEducacionalEntity> diarioEducacionalOpcional =
                diarioEducacionalRepository.findById(id);

        if (diarioEducacionalOpcional.isPresent())
            return diarioEducacionalMapper.deDiarioEducacionalEntityParaDiarioEducacionalDTO(
                    diarioEducacionalOpcional.get()
            );

        throw new DiarioEducacionalNaoEncontradoException(Constantes.DIARIO_EDUCACIONAL_NAO_ENCONTRADO);
    }
}