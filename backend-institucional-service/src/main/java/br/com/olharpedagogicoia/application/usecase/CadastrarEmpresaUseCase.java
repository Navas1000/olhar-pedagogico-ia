package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.EmpresaDto;
import br.com.olharpedagogicoia.application.port.in.CadastrarEmpresaPortIn;
import br.com.olharpedagogicoia.application.port.out.CadastrarEmpresaPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
@AllArgsConstructor
public class CadastrarEmpresaUseCase implements CadastrarEmpresaPortIn {

    final CadastrarEmpresaPortOut cadastrarEmpresaPortOut;

    @Override
    public EmpresaDto cadastrar(final EmpresaDto empresaDTO) {

        empresaDTO.setDataModificacao(LocalDateTime.now());
        empresaDTO.setDataCriacao(LocalDateTime.now());

        final EmpresaDto empresaDto = cadastrarEmpresaPortOut.cadastrar(empresaDTO);

        log.info("Empresa cadastrada com sucesso: {}", empresaDto);
        return empresaDto;


    }
}
