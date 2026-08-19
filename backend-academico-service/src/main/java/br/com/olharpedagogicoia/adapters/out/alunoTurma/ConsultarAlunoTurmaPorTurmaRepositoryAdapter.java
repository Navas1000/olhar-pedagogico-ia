package br.com.olharpedagogicoia.adapters.out.alunoTurma;

import br.com.olharpedagogicoia.adapters.out.alunoTurma.entity.AlunoTurmaEntity;
import br.com.olharpedagogicoia.adapters.out.alunoTurma.mapper.AlunoTurmaMapper;
import br.com.olharpedagogicoia.adapters.out.alunoTurma.repository.AlunoTurmaRepository;
import br.com.olharpedagogicoia.application.dto.AlunoTurmaDTO;
import br.com.olharpedagogicoia.application.port.out.ConsultarAlunoTurmaPorTurmaPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ConsultarAlunoTurmaPorTurmaRepositoryAdapter
        implements ConsultarAlunoTurmaPorTurmaPortOut {

    private final AlunoTurmaRepository alunoTurmaRepository;
    private final AlunoTurmaMapper alunoTurmaMapper;

    @Override
    public List<AlunoTurmaDTO> consultarPorTurma(final Integer idTurma) {

        final List<AlunoTurmaEntity> alunos =
                alunoTurmaRepository.findByIdTurma(idTurma);

        return alunos.stream()
                .map(alunoTurmaMapper::deAlunoTurmaEntityParaAlunoTurmaDTO)
                .toList();
    }
}