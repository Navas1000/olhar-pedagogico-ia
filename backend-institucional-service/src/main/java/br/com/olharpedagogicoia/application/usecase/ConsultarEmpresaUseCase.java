package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.EmpresaDTO;
import br.com.olharpedagogicoia.application.exceptions.EmpresaNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.in.ConsultarEmpresaPortIn;
import br.com.olharpedagogicoia.application.port.out.ConsultarEmpresaPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ConsultarEmpresaUseCase implements ConsultarEmpresaPortIn {

    final ConsultarEmpresaPortOut consultarEmpresaPortOut;

    @Override
    public EmpresaDTO consultar(Integer id) throws EmpresaNaoEncontradaException {

        return consultarEmpresaPortOut.consultar(id);

    }
}
