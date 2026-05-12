package br.com.olharpedagogicoia.adapters.out.empresa;

import br.com.olharpedagogicoia.adapters.out.empresa.entity.EmpresaEntity;
import br.com.olharpedagogicoia.adapters.out.empresa.mapper.EmpresaMapper;
import br.com.olharpedagogicoia.adapters.out.empresa.repository.EmpresaRepository;
import br.com.olharpedagogicoia.application.dto.EmpresaDTO;
import br.com.olharpedagogicoia.application.exceptions.Constantes;
import br.com.olharpedagogicoia.application.exceptions.EmpresaNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.out.ConsultarEmpresaPortOut;
import br.com.olharpedagogicoia.application.port.out.RemoverEmpresaPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RemoverEmpresaRepositoryAdapter implements RemoverEmpresaPortOut {

    private final EmpresaRepository empresaRepository;
    private final EmpresaMapper empresaMapper;

    public void remover(final Integer idEmpresa) throws EmpresaNaoEncontradaException {

        final Optional<EmpresaEntity> empresaOpcional = empresaRepository.findById(idEmpresa);

        if (empresaOpcional.isPresent())
            empresaRepository.deleteById(idEmpresa);

        else
            throw new EmpresaNaoEncontradaException(Constantes.EMPRESA_NAO_ENCONTRADA);

    }

}
