package br.com.olharpedagogicoia.adapters.out.aluno;

import br.com.olharpedagogicoia.adapters.out.aluno.entity.AlunoEntity;
import br.com.olharpedagogicoia.adapters.out.aluno.repository.AlunoRepository;
import br.com.olharpedagogicoia.application.exceptions.AlunoNaoEncontradoException;
import br.com.olharpedagogicoia.application.exceptions.Constantes;
import br.com.olharpedagogicoia.application.port.out.RemoverAlunoPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RemoverAlunoRepositoryAdapter implements RemoverAlunoPortOut {

    private final AlunoRepository alunoRepository;

    @Override
    public void remover(final Integer id) throws AlunoNaoEncontradoException {

        final Optional<AlunoEntity> alunoOpcional = alunoRepository.findById(id);

        if (alunoOpcional.isPresent())
            alunoRepository.deleteById(id);
        else
            throw new AlunoNaoEncontradoException(Constantes.ALUNO_NAO_ENCONTRADO);
    }
}