package br.com.olharpedagogicoia.adapters.out.turma;

import br.com.olharpedagogicoia.adapters.out.turma.entity.TurmaEntity;
import br.com.olharpedagogicoia.adapters.out.turma.repository.TurmaRepository;
import br.com.olharpedagogicoia.application.exceptions.Constantes;
import br.com.olharpedagogicoia.application.exceptions.TurmaNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.out.RemoverTurmaPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RemoverTurmaRepositoryAdapter implements RemoverTurmaPortOut {

    private final TurmaRepository turmaRepository;

    public void remover(final Integer id) throws TurmaNaoEncontradaException {

        final Optional<TurmaEntity> turmaOpcional = turmaRepository.findById(id);

        if (turmaOpcional.isPresent())
            turmaRepository.deleteById(id);
        else
            throw new TurmaNaoEncontradaException(Constantes.TURMA_NAO_ENCONTRADA);

    }

}