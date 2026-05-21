package br.com.olharpedagogicoia.adapters.out.turma;

import br.com.olharpedagogicoia.adapters.out.turma.entity.TurmaEntity;
import br.com.olharpedagogicoia.adapters.out.turma.mapper.TurmaMapper;
import br.com.olharpedagogicoia.adapters.out.turma.repository.TurmaRepository;
import br.com.olharpedagogicoia.application.dto.TurmaDto;
import br.com.olharpedagogicoia.application.exceptions.Constantes;
import br.com.olharpedagogicoia.application.exceptions.TurmaNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.out.ConsultarTurmaPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ConsultarTurmaRepositoryAdapter implements ConsultarTurmaPortOut {

    private final TurmaRepository turmaRepository;
    private final TurmaMapper turmaMapper;

    public TurmaDto consultar(final Integer id) throws TurmaNaoEncontradaException {

        final Optional<TurmaEntity> turmaOpcional = turmaRepository.findById(id);

        if (turmaOpcional.isPresent())
            return turmaMapper.deTurmaEntityParaTurmaDTO(turmaOpcional.get());

        throw new TurmaNaoEncontradaException(Constantes.TURMA_NAO_ENCONTRADA);

    }

}