package br.com.olharpedagogicoia.adapters.out.pessoa;

import br.com.olharpedagogicoia.adapters.out.pessoa.entity.PessoaEntity;
import br.com.olharpedagogicoia.adapters.out.pessoa.mapper.PessoaMapper;
import br.com.olharpedagogicoia.adapters.out.pessoa.repository.PessoaRepository;
import br.com.olharpedagogicoia.application.dto.PessoaDTO;
import br.com.olharpedagogicoia.application.port.out.AtualizarPessoaPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AtualizarPessoaRepositoryAdapter implements AtualizarPessoaPortOut {

    private final PessoaRepository pessoaRepository;
    private final PessoaMapper pessoaMapper;

    @Override
    public PessoaDTO atualizar(final PessoaDTO pessoaDTO) {

        final PessoaEntity pessoaEntity =
                pessoaMapper.dePessoaDTOParaPessoaEntity(pessoaDTO);

        final PessoaEntity pessoaSalva =
                pessoaRepository.save(pessoaEntity);

        return pessoaMapper.dePessoaEntityParaPessoaDTO(pessoaSalva);
    }
}