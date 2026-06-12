package br.com.olharpedagogicoia.adapters.out.diarioEducacional;

import br.com.olharpedagogicoia.adapters.out.diarioEducacional.entity.DiarioEducacionalEntity;
import br.com.olharpedagogicoia.adapters.out.diarioEducacional.repository.DiarioEducacionalRepository;
import br.com.olharpedagogicoia.application.exceptions.Constantes;
import br.com.olharpedagogicoia.application.exceptions.DiarioEducacionalNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.out.RemoverDiarioEducacionalPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RemoverDiarioEducacionalRepositoryAdapter implements RemoverDiarioEducacionalPortOut {

    private final DiarioEducacionalRepository diarioEducacionalRepository;

    @Override
    public void remover(final Integer id) throws DiarioEducacionalNaoEncontradoException {

        final Optional<DiarioEducacionalEntity> diarioEducacionalOpcional =
                diarioEducacionalRepository.findById(id);

        if (diarioEducacionalOpcional.isPresent())
            diarioEducacionalRepository.deleteById(id);
        else
            throw new DiarioEducacionalNaoEncontradoException(Constantes.DIARIO_EDUCACIONAL_NAO_ENCONTRADO);
    }
}