package br.com.olharpedagogicoia.adapters.out.turma;

import br.com.olharpedagogicoia.adapters.out.turma.entity.TurmaEntity;
import br.com.olharpedagogicoia.adapters.out.turma.mapper.TurmaMapper;
import br.com.olharpedagogicoia.adapters.out.turma.repository.TurmaRepository;
import br.com.olharpedagogicoia.application.dto.TurmaDto;
import br.com.olharpedagogicoia.application.port.out.AtualizarTurmaPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AtualizarTurmaRepositoryAdapter implements AtualizarTurmaPortOut {

    private final TurmaRepository turmaRepository;
    private final TurmaMapper turmaMapper;

    @Override
    public TurmaDto atualizar(final TurmaDto turmaDto) {

        final TurmaEntity turmaEntity =
                turmaMapper.deTurmaDTOParaTurmaEntity(turmaDto);

        final TurmaEntity turmaSalva =
                turmaRepository.save(turmaEntity);

        return turmaMapper.deTurmaEntityParaTurmaDTO(turmaSalva);

    }

}