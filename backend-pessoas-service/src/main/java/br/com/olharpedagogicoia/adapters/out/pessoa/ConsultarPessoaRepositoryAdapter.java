package br.com.olharpedagogicoia.adapters.out.pessoa;

import br.com.olharpedagogicoia.adapters.out.pessoa.entity.PessoaEntity;
import br.com.olharpedagogicoia.adapters.out.pessoa.mapper.PessoaMapper;
import br.com.olharpedagogicoia.adapters.out.pessoa.repository.PessoaRepository;
import br.com.olharpedagogicoia.application.dto.PessoaDTO;
import br.com.olharpedagogicoia.application.exceptions.Constantes;
import br.com.olharpedagogicoia.application.exceptions.PessoaNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.out.ConsultarPessoaPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ConsultarPessoaRepositoryAdapter implements ConsultarPessoaPortOut {

    private final PessoaRepository pessoaRepository;
    private final PessoaMapper pessoaMapper;

    @Override
    public PessoaDTO consultar(final Integer id) throws PessoaNaoEncontradaException {

        final Optional<PessoaEntity> pessoaOpcional = pessoaRepository.findById(id);

        if (pessoaOpcional.isPresent())
            return pessoaMapper.dePessoaEntityParaPessoaDTO(pessoaOpcional.get());

        throw new PessoaNaoEncontradaException(Constantes.PESSOA_NAO_ENCONTRADA);
    }
}