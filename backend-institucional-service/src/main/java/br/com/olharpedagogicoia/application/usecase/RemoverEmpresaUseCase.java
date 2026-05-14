package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.exceptions.EmpresaNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.in.RemoverEmpresaPortIn;
import br.com.olharpedagogicoia.application.port.out.RemoverEmpresaPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RemoverEmpresaUseCase implements RemoverEmpresaPortIn {

    final RemoverEmpresaPortOut removerEmpresaPortOut;

    @Override
    public void remover(final Integer idEmpresa) throws EmpresaNaoEncontradaException {

        removerEmpresaPortOut.remover(idEmpresa);

    }
}
