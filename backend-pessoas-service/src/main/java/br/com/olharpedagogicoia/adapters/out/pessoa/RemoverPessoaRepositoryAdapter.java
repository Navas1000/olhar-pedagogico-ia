package br.com.olharpedagogicoia.adapters.out.pessoa;

import br.com.olharpedagogicoia.adapters.out.pessoa.entity.PessoaEntity;
import br.com.olharpedagogicoia.adapters.out.pessoa.repository.PessoaRepository;
import br.com.olharpedagogicoia.application.exceptions.Constantes;
import br.com.olharpedagogicoia.application.exceptions.PessoaNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.out.RemoverPessoaPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RemoverPessoaRepositoryAdapter implements RemoverPessoaPortOut {

    private final PessoaRepository pessoaRepository;

    @Override
    public void remover(final Integer id) throws PessoaNaoEncontradaException {

        final Optional<PessoaEntity> pessoaOpcional = pessoaRepository.findById(id);

        if (pessoaOpcional.isPresent())
            pessoaRepository.deleteById(id);
        else
            throw new PessoaNaoEncontradaException(Constantes.PESSOA_NAO_ENCONTRADA);
    }
}