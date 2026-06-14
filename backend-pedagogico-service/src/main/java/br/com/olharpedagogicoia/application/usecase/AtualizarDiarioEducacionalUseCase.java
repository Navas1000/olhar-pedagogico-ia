package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.DiarioEducacionalDTO;
import br.com.olharpedagogicoia.application.exceptions.Constantes;
import br.com.olharpedagogicoia.application.exceptions.DiarioEducacionalNaoEncontradoException;
import br.com.olharpedagogicoia.application.exceptions.IdDiarioEducacionalObrigatorioException;
import br.com.olharpedagogicoia.application.port.in.AtualizarDiarioEducacionalPortIn;
import br.com.olharpedagogicoia.application.port.out.AtualizarDiarioEducacionalPortOut;
import br.com.olharpedagogicoia.application.port.out.ConsultarDiarioEducacionalPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@Component
@AllArgsConstructor
public class AtualizarDiarioEducacionalUseCase implements AtualizarDiarioEducacionalPortIn {

    final AtualizarDiarioEducacionalPortOut atualizarDiarioEducacionalPortOut;
    final ConsultarDiarioEducacionalPortOut consultarDiarioEducacionalPortOut;

    @Override
    public DiarioEducacionalDTO atualizar(final DiarioEducacionalDTO diarioEducacionalDTO)
            throws DiarioEducacionalNaoEncontradoException, IdDiarioEducacionalObrigatorioException {

        if (Objects.isNull(diarioEducacionalDTO.getIdDiario()))
            throw new IdDiarioEducacionalObrigatorioException(Constantes.ID_DIARIO_EDUCACIONAL_OBRIGATORIO);

        final DiarioEducacionalDTO diarioEducacionalConsultado =
                consultarDiarioEducacionalPortOut.consultar(diarioEducacionalDTO.getIdDiario());

        diarioEducacionalDTO.setDataCriacao(diarioEducacionalConsultado.getDataCriacao());

        final DiarioEducacionalDTO diarioEducacionalAtualizado =
                atualizarDiarioEducacionalPortOut.atualizar(diarioEducacionalDTO);

        log.info("Diário educacional atualizado com sucesso: {}", diarioEducacionalAtualizado);

        return diarioEducacionalAtualizado;
    }
}