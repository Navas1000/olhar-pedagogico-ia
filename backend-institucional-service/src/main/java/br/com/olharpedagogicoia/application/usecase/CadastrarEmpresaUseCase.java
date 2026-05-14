package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.EmpresaDto;
import br.com.olharpedagogicoia.application.port.in.CadastrarEmpresaPortIn;
import br.com.olharpedagogicoia.application.port.out.CadastrarEmpresaPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class CadastrarEmpresaUseCase implements CadastrarEmpresaPortIn {

    final CadastrarEmpresaPortOut cadastrarEmpresaPortOut;

    @Override
    public EmpresaDto cadastrar(final EmpresaDto empresaDTO) {

        empresaDTO.setDataModificacao(LocalDateTime.now());
        empresaDTO.setDataCriacao(LocalDateTime.now());
        return cadastrarEmpresaPortOut.cadastrar(empresaDTO);


    }
}
