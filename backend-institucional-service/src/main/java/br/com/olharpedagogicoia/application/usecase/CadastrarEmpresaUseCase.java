package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.EmpresaDTO;
import br.com.olharpedagogicoia.application.exceptions.EmpresaNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.in.CadastrarEmpresaPortIn;
import br.com.olharpedagogicoia.application.port.in.ConsultarEmpresaPortIn;
import br.com.olharpedagogicoia.application.port.in.RemoverEmpresaPortIn;
import br.com.olharpedagogicoia.application.port.out.CadastrarEmpresaPortOut;
import br.com.olharpedagogicoia.application.port.out.ConsultarEmpresaPortOut;
import br.com.olharpedagogicoia.application.port.out.RemoverEmpresaPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class CadastrarEmpresaUseCase implements CadastrarEmpresaPortIn {

    final CadastrarEmpresaPortOut cadastrarEmpresaPortOut;

    @Override
    public EmpresaDTO cadastrar(final EmpresaDTO empresaDTO) {

        empresaDTO.setDataModificacao(LocalDateTime.now());
        empresaDTO.setDataCriacao(LocalDateTime.now());
        return cadastrarEmpresaPortOut.cadastrar(empresaDTO);


    }
}
