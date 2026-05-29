package br.com.olharpedagogicoia.adapters.out.funcionario;

import br.com.olharpedagogicoia.adapters.out.funcionario.entity.FuncionarioEntity;
import br.com.olharpedagogicoia.adapters.out.funcionario.mapper.FuncionarioMapper;
import br.com.olharpedagogicoia.adapters.out.funcionario.repository.FuncionarioRepository;
import br.com.olharpedagogicoia.application.dto.FuncionarioDTO;
import br.com.olharpedagogicoia.application.exceptions.Constantes;
import br.com.olharpedagogicoia.application.exceptions.FuncionarioNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.out.ConsultarFuncionarioPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ConsultarFuncionarioRepositoryAdapter implements ConsultarFuncionarioPortOut {

    private final FuncionarioRepository funcionarioRepository;
    private final FuncionarioMapper funcionarioMapper;

    @Override
    public FuncionarioDTO consultar(final Integer id) throws FuncionarioNaoEncontradoException {

        final Optional<FuncionarioEntity> funcionarioOpcional = funcionarioRepository.findById(id);

        if (funcionarioOpcional.isPresent())
            return funcionarioMapper.deFuncionarioEntityParaFuncionarioDTO(funcionarioOpcional.get());

        throw new FuncionarioNaoEncontradoException(Constantes.FUNCIONARIO_NAO_ENCONTRADO);
    }
}