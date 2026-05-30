package br.com.olharpedagogicoia.adapters.out.funcionario;

import br.com.olharpedagogicoia.adapters.out.funcionario.entity.FuncionarioEntity;
import br.com.olharpedagogicoia.adapters.out.funcionario.repository.FuncionarioRepository;
import br.com.olharpedagogicoia.application.exceptions.Constantes;
import br.com.olharpedagogicoia.application.exceptions.FuncionarioNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.out.RemoverFuncionarioPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RemoverFuncionarioRepositoryAdapter implements RemoverFuncionarioPortOut {

    private final FuncionarioRepository funcionarioRepository;

    @Override
    public void remover(final Integer id) throws FuncionarioNaoEncontradoException {

        final Optional<FuncionarioEntity> funcionarioOpcional = funcionarioRepository.findById(id);

        if (funcionarioOpcional.isPresent())
            funcionarioRepository.deleteById(id);
        else
            throw new FuncionarioNaoEncontradoException(Constantes.FUNCIONARIO_NAO_ENCONTRADO);
    }
}