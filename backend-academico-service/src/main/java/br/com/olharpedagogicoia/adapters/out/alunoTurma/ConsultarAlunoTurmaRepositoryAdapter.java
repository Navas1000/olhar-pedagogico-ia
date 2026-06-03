package br.com.olharpedagogicoia.adapters.out.alunoTurma;

import br.com.olharpedagogicoia.adapters.out.alunoTurma.entity.AlunoTurmaEntity;
import br.com.olharpedagogicoia.adapters.out.alunoTurma.mapper.AlunoTurmaMapper;
import br.com.olharpedagogicoia.adapters.out.alunoTurma.repository.AlunoTurmaRepository;
import br.com.olharpedagogicoia.application.dto.AlunoTurmaDTO;
import br.com.olharpedagogicoia.application.exceptions.AlunoTurmaNaoEncontradaException;
import br.com.olharpedagogicoia.application.exceptions.Constantes;
import br.com.olharpedagogicoia.application.port.out.ConsultarAlunoTurmaPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ConsultarAlunoTurmaRepositoryAdapter implements ConsultarAlunoTurmaPortOut {

    private final AlunoTurmaRepository alunoTurmaRepository;
    private final AlunoTurmaMapper alunoTurmaMapper;

    @Override
    public AlunoTurmaDTO consultar(final Integer id) throws AlunoTurmaNaoEncontradaException {

        final Optional<AlunoTurmaEntity> alunoTurmaOpcional = alunoTurmaRepository.findById(id);

        if (alunoTurmaOpcional.isPresent())
            return alunoTurmaMapper.deAlunoTurmaEntityParaAlunoTurmaDTO(alunoTurmaOpcional.get());

        throw new AlunoTurmaNaoEncontradaException(Constantes.ALUNO_TURMA_NAO_ENCONTRADA);
    }
}