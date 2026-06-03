package br.com.olharpedagogicoia.adapters.out.alunoTurma;

import br.com.olharpedagogicoia.adapters.out.alunoTurma.entity.AlunoTurmaEntity;
import br.com.olharpedagogicoia.adapters.out.alunoTurma.repository.AlunoTurmaRepository;
import br.com.olharpedagogicoia.application.exceptions.AlunoTurmaNaoEncontradaException;
import br.com.olharpedagogicoia.application.exceptions.Constantes;
import br.com.olharpedagogicoia.application.port.out.RemoverAlunoTurmaPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RemoverAlunoTurmaRepositoryAdapter implements RemoverAlunoTurmaPortOut {

    private final AlunoTurmaRepository alunoTurmaRepository;

    @Override
    public void remover(final Integer id) throws AlunoTurmaNaoEncontradaException {

        final Optional<AlunoTurmaEntity> alunoTurmaOpcional = alunoTurmaRepository.findById(id);

        if (alunoTurmaOpcional.isPresent())
            alunoTurmaRepository.deleteById(id);
        else
            throw new AlunoTurmaNaoEncontradaException(Constantes.ALUNO_TURMA_NAO_ENCONTRADA);
    }
}