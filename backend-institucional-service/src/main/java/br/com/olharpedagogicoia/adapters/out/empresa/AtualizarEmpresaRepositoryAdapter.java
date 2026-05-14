package br.com.olharpedagogicoia.adapters.out.empresa;

import br.com.olharpedagogicoia.adapters.out.empresa.entity.EmpresaEntity;
import br.com.olharpedagogicoia.adapters.out.empresa.mapper.EmpresaMapper;
import br.com.olharpedagogicoia.adapters.out.empresa.repository.EmpresaRepository;
import br.com.olharpedagogicoia.application.dto.EmpresaDto;
import br.com.olharpedagogicoia.application.port.out.AtualizarEmpresaPortOut;
import br.com.olharpedagogicoia.application.port.out.CadastrarEmpresaPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AtualizarEmpresaRepositoryAdapter implements AtualizarEmpresaPortOut {

    private final EmpresaRepository empresaRepository;
    private final EmpresaMapper empresaMapper;

    @Override
    public EmpresaDto atualizar(final EmpresaDto empresaDTO) {

        final EmpresaEntity empresaEntity =
                empresaMapper.deEmpresaDTOParaEmpresaEntity(empresaDTO);

        final EmpresaEntity empresaSalva =
                empresaRepository.save(empresaEntity);

        return empresaMapper.deEmpresaEntityParaEmpresaDTO(empresaSalva);

    }

}
