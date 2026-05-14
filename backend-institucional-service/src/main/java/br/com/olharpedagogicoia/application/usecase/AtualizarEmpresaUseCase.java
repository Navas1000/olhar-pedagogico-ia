package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.EmpresaDto;
import br.com.olharpedagogicoia.application.exceptions.Constantes;
import br.com.olharpedagogicoia.application.exceptions.EmpresaNaoEncontradaException;
import br.com.olharpedagogicoia.application.exceptions.IdEmpresaObrigatorioException;
import br.com.olharpedagogicoia.application.port.in.AtualizarEmpresaPortIn;
import br.com.olharpedagogicoia.application.port.in.CadastrarEmpresaPortIn;
import br.com.olharpedagogicoia.application.port.out.AtualizarEmpresaPortOut;
import br.com.olharpedagogicoia.application.port.out.CadastrarEmpresaPortOut;
import br.com.olharpedagogicoia.application.port.out.ConsultarEmpresaPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;

@Component
@AllArgsConstructor
public class AtualizarEmpresaUseCase implements AtualizarEmpresaPortIn {

    final AtualizarEmpresaPortOut atualizarEmpresaPortOut;
    final ConsultarEmpresaPortOut consultarEmpresaPortOut;

    @Override
    public EmpresaDto atualizar(final EmpresaDto empresaDTO) throws EmpresaNaoEncontradaException, IdEmpresaObrigatorioException {

        if(Objects.isNull(empresaDTO.getIdEmpresa()))
            throw new IdEmpresaObrigatorioException(Constantes.ID_EMPRESA_OBRIGATORIO);

        final EmpresaDto empresaConsultada = consultarEmpresaPortOut.consultar(empresaDTO.getIdEmpresa());

        empresaDTO.setDataCriacao(empresaConsultada.getDataCriacao());
        empresaDTO.setDataModificacao(LocalDateTime.now());

        return atualizarEmpresaPortOut.atualizar(empresaDTO);


    }
}
