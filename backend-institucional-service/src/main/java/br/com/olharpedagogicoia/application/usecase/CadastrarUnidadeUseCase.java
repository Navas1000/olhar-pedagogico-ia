package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.EmpresaDto;
import br.com.olharpedagogicoia.application.dto.UnidadeDto;
import br.com.olharpedagogicoia.application.port.in.CadastrarEmpresaPortIn;
import br.com.olharpedagogicoia.application.port.in.CadastrarUnidadePortIn;
import br.com.olharpedagogicoia.application.port.out.CadastrarEmpresaPortOut;
import br.com.olharpedagogicoia.application.port.out.CadastrarUnidadePortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class CadastrarUnidadeUseCase implements CadastrarUnidadePortIn {

    final CadastrarUnidadePortOut cadastrarUnidadePortOut;

    @Override
    public UnidadeDto cadastrar(final UnidadeDto unidadeDto) {

        unidadeDto.setDataModificacao(LocalDateTime.now());
        unidadeDto.setDataCriacao(LocalDateTime.now());
        return cadastrarUnidadePortOut.cadastrar(unidadeDto);

    }
}
