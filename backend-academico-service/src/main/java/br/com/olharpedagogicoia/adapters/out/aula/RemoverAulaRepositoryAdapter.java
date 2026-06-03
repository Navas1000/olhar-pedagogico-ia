package br.com.olharpedagogicoia.adapters.out.aula;

import br.com.olharpedagogicoia.adapters.out.aula.entity.AulaEntity;
import br.com.olharpedagogicoia.adapters.out.aula.repository.AulaRepository;
import br.com.olharpedagogicoia.application.exceptions.AulaNaoEncontradaException;
import br.com.olharpedagogicoia.application.exceptions.Constantes;
import br.com.olharpedagogicoia.application.port.out.RemoverAulaPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RemoverAulaRepositoryAdapter implements RemoverAulaPortOut {

    private final AulaRepository aulaRepository;

    @Override
    public void remover(final Integer id) throws AulaNaoEncontradaException {

        final Optional<AulaEntity> aulaOpcional = aulaRepository.findById(id);

        if (aulaOpcional.isPresent())
            aulaRepository.deleteById(id);
        else
            throw new AulaNaoEncontradaException(Constantes.AULA_NAO_ENCONTRADA);
    }
}