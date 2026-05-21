package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.EmpresaDto;
import br.com.olharpedagogicoia.application.dto.UnidadeDto;
import br.com.olharpedagogicoia.application.exceptions.*;
import br.com.olharpedagogicoia.application.port.in.AtualizarEmpresaPortIn;
import br.com.olharpedagogicoia.application.port.in.AtualizarUnidadePortIn;
import br.com.olharpedagogicoia.application.port.out.AtualizarEmpresaPortOut;
import br.com.olharpedagogicoia.application.port.out.AtualizarUnidadePortOut;
import br.com.olharpedagogicoia.application.port.out.ConsultarEmpresaPortOut;
import br.com.olharpedagogicoia.application.port.out.ConsultarUnidadePortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;

@Component
@AllArgsConstructor
public class AtualizarUnidadeUseCase implements AtualizarUnidadePortIn {

    final AtualizarUnidadePortOut atualizarUnidadePortOut;
    final ConsultarUnidadePortOut consultarUnidadePortOut;

    @Override
    public UnidadeDto atualizar(final UnidadeDto unidadeDto) throws UnidadeNaoEncontradaException, IdUnidadeObrigatorioException {

        if(Objects.isNull(unidadeDto.getIdUnidade()))
            throw new IdUnidadeObrigatorioException(Constantes.ID_UNIDADE_OBRIGATORIO);

        final UnidadeDto unidadeConsultada = consultarUnidadePortOut.consultar(unidadeDto.getIdUnidade());

        unidadeDto.setDataCriacao(unidadeConsultada.getDataCriacao());
        unidadeDto.setDataModificacao(LocalDateTime.now());

        return atualizarUnidadePortOut.atualizar(unidadeDto);


    }
}
