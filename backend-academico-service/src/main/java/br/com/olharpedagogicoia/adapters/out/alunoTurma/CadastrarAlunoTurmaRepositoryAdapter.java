package br.com.olharpedagogicoia.adapters.out.alunoTurma;

import br.com.olharpedagogicoia.adapters.out.alunoTurma.entity.AlunoTurmaEntity;
import br.com.olharpedagogicoia.adapters.out.alunoTurma.mapper.AlunoTurmaMapper;
import br.com.olharpedagogicoia.adapters.out.alunoTurma.repository.AlunoTurmaRepository;
import br.com.olharpedagogicoia.application.dto.AlunoTurmaDTO;
import br.com.olharpedagogicoia.application.port.out.CadastrarAlunoTurmaPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CadastrarAlunoTurmaRepositoryAdapter implements CadastrarAlunoTurmaPortOut {

    private final AlunoTurmaRepository alunoTurmaRepository;
    private final AlunoTurmaMapper alunoTurmaMapper;

    @Override
    public AlunoTurmaDTO cadastrar(final AlunoTurmaDTO alunoTurmaDTO) {

        final AlunoTurmaEntity alunoTurmaEntity =
                alunoTurmaMapper.deAlunoTurmaDTOParaAlunoTurmaEntity(alunoTurmaDTO);

        final AlunoTurmaEntity alunoTurmaSalvo =
                alunoTurmaRepository.save(alunoTurmaEntity);

        return alunoTurmaMapper.deAlunoTurmaEntityParaAlunoTurmaDTO(alunoTurmaSalvo);
    }
}