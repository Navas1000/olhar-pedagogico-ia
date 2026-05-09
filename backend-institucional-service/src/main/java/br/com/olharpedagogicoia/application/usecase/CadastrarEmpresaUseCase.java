package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.EmpresaDTO;
import br.com.olharpedagogicoia.application.port.in.CadastrarEmpresaPortIn;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CadastrarEmpresaUseCase implements CadastrarEmpresaPortIn {

    @Override
    public EmpresaDTO cadastrar(EmpresaDTO empresaDTO) {

        // ir no banco e gravar as informações
        EmpresaDTO empresaConsultada = new EmpresaDTO();

        empresaConsultada.setIdEmpresa(1);
        empresaConsultada.setNome("Ursinho Pimpao");
        empresaConsultada.setCnpj("12312312312");
        empresaConsultada.setAtivo(true);
        empresaConsultada.setDataCriacao(LocalDateTime.now());
        empresaConsultada.setDataModificacao(LocalDateTime.now());


return empresaConsultada;
    }
}
