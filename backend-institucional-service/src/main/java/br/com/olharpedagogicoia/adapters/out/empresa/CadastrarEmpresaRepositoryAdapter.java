package br.com.olharpedagogicoia.adapters.out.empresa;

import br.com.olharpedagogicoia.adapters.out.empresa.entity.EmpresaEntity;
import br.com.olharpedagogicoia.adapters.out.empresa.mapper.EmpresaMapper;
import br.com.olharpedagogicoia.adapters.out.empresa.repository.EmpresaRepository;
import br.com.olharpedagogicoia.application.dto.EmpresaDTO;
import br.com.olharpedagogicoia.application.exceptions.Constantes;
import br.com.olharpedagogicoia.application.exceptions.EmpresaNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.out.CadastrarEmpresaPortOut;
import br.com.olharpedagogicoia.application.port.out.RemoverEmpresaPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CadastrarEmpresaRepositoryAdapter implements CadastrarEmpresaPortOut {

    private final EmpresaRepository empresaRepository;
    private final EmpresaMapper empresaMapper;

    @Override
    public EmpresaDTO cadastrar(final EmpresaDTO empresaDTO) {

        final EmpresaEntity empresaEntity =
                empresaMapper.deEmpresaDTOParaEmpresaEntity(empresaDTO);

        final EmpresaEntity empresaSalva =
                empresaRepository.save(empresaEntity);

        return empresaMapper.deEmpresaEntityParaEmpresaDTO(empresaSalva);

    }

}
