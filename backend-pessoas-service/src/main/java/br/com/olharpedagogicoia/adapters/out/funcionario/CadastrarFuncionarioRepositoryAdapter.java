package br.com.olharpedagogicoia.adapters.out.funcionario;

import br.com.olharpedagogicoia.adapters.out.funcionario.entity.FuncionarioEntity;
import br.com.olharpedagogicoia.adapters.out.funcionario.mapper.FuncionarioMapper;
import br.com.olharpedagogicoia.adapters.out.funcionario.repository.FuncionarioRepository;
import br.com.olharpedagogicoia.application.dto.FuncionarioDTO;
import br.com.olharpedagogicoia.application.port.out.CadastrarFuncionarioPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CadastrarFuncionarioRepositoryAdapter implements CadastrarFuncionarioPortOut {

    private final FuncionarioRepository funcionarioRepository;
    private final FuncionarioMapper funcionarioMapper;

    @Override
    public FuncionarioDTO cadastrar(final FuncionarioDTO funcionarioDTO) {

        final FuncionarioEntity funcionarioEntity =
                funcionarioMapper.deFuncionarioDTOParaFuncionarioEntity(funcionarioDTO);

        final FuncionarioEntity funcionarioSalvo =
                funcionarioRepository.save(funcionarioEntity);

        return funcionarioMapper.deFuncionarioEntityParaFuncionarioDTO(funcionarioSalvo);
    }
}