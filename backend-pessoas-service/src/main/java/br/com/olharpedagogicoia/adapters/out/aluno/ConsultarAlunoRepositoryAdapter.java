package br.com.olharpedagogicoia.adapters.out.aluno;

import br.com.olharpedagogicoia.adapters.out.aluno.entity.AlunoEntity;
import br.com.olharpedagogicoia.adapters.out.aluno.mapper.AlunoMapper;
import br.com.olharpedagogicoia.adapters.out.aluno.repository.AlunoRepository;
import br.com.olharpedagogicoia.application.dto.AlunoDTO;
import br.com.olharpedagogicoia.application.exceptions.AlunoNaoEncontradoException;
import br.com.olharpedagogicoia.application.exceptions.Constantes;
import br.com.olharpedagogicoia.application.port.out.ConsultarAlunoPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ConsultarAlunoRepositoryAdapter implements ConsultarAlunoPortOut {

    private final AlunoRepository alunoRepository;
    private final AlunoMapper alunoMapper;

    @Override
    public AlunoDTO consultar(final Integer id) throws AlunoNaoEncontradoException {

        final Optional<AlunoEntity> alunoOpcional = alunoRepository.findById(id);

        if (alunoOpcional.isPresent())
            return alunoMapper.deAlunoEntityParaAlunoDTO(alunoOpcional.get());

        throw new AlunoNaoEncontradoException(Constantes.ALUNO_NAO_ENCONTRADO);
    }
}