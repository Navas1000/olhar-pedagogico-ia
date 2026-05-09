package br.com.olharpedagogicoia.adapters.out.empresa;

import br.com.olharpedagogicoia.adapters.out.empresa.entity.EmpresaEntity;
import br.com.olharpedagogicoia.adapters.out.empresa.repository.EmpresaRepository;
import br.com.olharpedagogicoia.application.dto.EmpresaDTO;
import br.com.olharpedagogicoia.application.exceptions.Constantes;
import br.com.olharpedagogicoia.application.exceptions.EmpresaNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.in.ConsultarEmpresaPortIn;
import br.com.olharpedagogicoia.application.port.out.ConsultarEmpresaPortOut;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmpresaRepositoryAdapter implements ConsultarEmpresaPortOut {

    private final int EMPRESA_ATIVA = 1;
    private final EmpresaRepository empresaRepository;

    public EmpresaDTO consultar(final Integer id) throws EmpresaNaoEncontradaException {

        final Optional<EmpresaEntity> empresaOpcional = empresaRepository.findById(id);

        if (empresaOpcional.isPresent()) {
            EmpresaEntity empresaRetornada = empresaOpcional.get();
            EmpresaDTO empresaConsultada = new EmpresaDTO();
            empresaConsultada.setIdEmpresa(empresaRetornada.getIdEmpresa());
            empresaConsultada.setNome(empresaRetornada.getNome());
            empresaConsultada.setCnpj(empresaRetornada.getCnpj());
            empresaConsultada.setAtivo(empresaRetornada.getAtivo() == EMPRESA_ATIVA);
            empresaConsultada.setDataCriacao(empresaRetornada.getDataCriacao());
            empresaConsultada.setDataModificacao(empresaRetornada.getDataModificacao());

            return empresaConsultada;
        }

        throw new EmpresaNaoEncontradaException(Constantes.EMPRESA_NAO_ENCONTRADA);

    }

}
