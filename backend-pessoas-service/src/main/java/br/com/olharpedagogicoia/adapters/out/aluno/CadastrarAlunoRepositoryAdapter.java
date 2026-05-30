package br.com.olharpedagogicoia.adapters.out.aluno;

import br.com.olharpedagogicoia.adapters.out.aluno.entity.AlunoEntity;
import br.com.olharpedagogicoia.adapters.out.aluno.mapper.AlunoMapper;
import br.com.olharpedagogicoia.adapters.out.aluno.repository.AlunoRepository;
import br.com.olharpedagogicoia.application.dto.AlunoDTO;
import br.com.olharpedagogicoia.application.port.out.CadastrarAlunoPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CadastrarAlunoRepositoryAdapter implements CadastrarAlunoPortOut {

    private final AlunoRepository alunoRepository;
    private final AlunoMapper alunoMapper;

    @Override
    public AlunoDTO cadastrar(final AlunoDTO alunoDTO) {

        final AlunoEntity alunoEntity =
                alunoMapper.deAlunoDTOParaAlunoEntity(alunoDTO);

        final AlunoEntity alunoSalvo =
                alunoRepository.save(alunoEntity);

        return alunoMapper.deAlunoEntityParaAlunoDTO(alunoSalvo);
    }
}