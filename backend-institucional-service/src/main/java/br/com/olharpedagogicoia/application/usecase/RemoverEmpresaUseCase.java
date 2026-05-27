package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.EmpresaDto;
import br.com.olharpedagogicoia.application.exceptions.EmpresaNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.in.RemoverEmpresaPortIn;
import br.com.olharpedagogicoia.application.port.out.RemoverEmpresaPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class RemoverEmpresaUseCase implements RemoverEmpresaPortIn {

    final RemoverEmpresaPortOut removerEmpresaPortOut;

    @Override
    public void remover(final Integer idEmpresa) throws EmpresaNaoEncontradaException {

        log.info("Empresa removida com sucesso: {}", idEmpresa);
        removerEmpresaPortOut.remover(idEmpresa);

    }
}
