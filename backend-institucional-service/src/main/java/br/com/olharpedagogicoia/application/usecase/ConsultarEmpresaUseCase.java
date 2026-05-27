package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.EmpresaDto;
import br.com.olharpedagogicoia.application.exceptions.EmpresaNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.in.ConsultarEmpresaPortIn;
import br.com.olharpedagogicoia.application.port.out.ConsultarEmpresaPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class ConsultarEmpresaUseCase implements ConsultarEmpresaPortIn {

    final ConsultarEmpresaPortOut consultarEmpresaPortOut;

    @Override
    public EmpresaDto consultar(final Integer id) throws EmpresaNaoEncontradaException {

        final EmpresaDto empresaDto = consultarEmpresaPortOut.consultar(id);

        log.info("Empresa consultada com sucesso: {}", empresaDto);

        return empresaDto;

    }
}
