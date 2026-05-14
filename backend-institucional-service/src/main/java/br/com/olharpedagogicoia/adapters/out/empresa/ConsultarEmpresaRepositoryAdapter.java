package br.com.olharpedagogicoia.adapters.out.empresa;

import br.com.olharpedagogicoia.adapters.out.empresa.entity.EmpresaEntity;
import br.com.olharpedagogicoia.adapters.out.empresa.mapper.EmpresaMapper;
import br.com.olharpedagogicoia.adapters.out.empresa.repository.EmpresaRepository;
import br.com.olharpedagogicoia.application.dto.EmpresaDto;
import br.com.olharpedagogicoia.application.exceptions.Constantes;
import br.com.olharpedagogicoia.application.exceptions.EmpresaNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.out.ConsultarEmpresaPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ConsultarEmpresaRepositoryAdapter implements ConsultarEmpresaPortOut {

    private final EmpresaRepository empresaRepository;
    private final EmpresaMapper empresaMapper;

    public EmpresaDto consultar(final Integer id) throws EmpresaNaoEncontradaException {

        final Optional<EmpresaEntity> empresaOpcional = empresaRepository.findById(id);

        if (empresaOpcional.isPresent())
            return empresaMapper.deEmpresaEntityParaEmpresaDTO(empresaOpcional.get());

        throw new EmpresaNaoEncontradaException(Constantes.EMPRESA_NAO_ENCONTRADA);

    }

}
