package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.ResumoEducacionalDTO;
import br.com.olharpedagogicoia.application.exceptions.Constantes;
import br.com.olharpedagogicoia.application.exceptions.IdResumoEducacionalObrigatorioException;
import br.com.olharpedagogicoia.application.exceptions.ResumoEducacionalNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.in.AtualizarResumoEducacionalPortIn;
import br.com.olharpedagogicoia.application.port.out.AtualizarResumoEducacionalPortOut;
import br.com.olharpedagogicoia.application.port.out.ConsultarResumoEducacionalPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@Component
@AllArgsConstructor
public class AtualizarResumoEducacionalUseCase implements AtualizarResumoEducacionalPortIn {

    final AtualizarResumoEducacionalPortOut atualizarResumoEducacionalPortOut;
    final ConsultarResumoEducacionalPortOut consultarResumoEducacionalPortOut;

    @Override
    public ResumoEducacionalDTO atualizar(final ResumoEducacionalDTO resumoEducacionalDTO)
            throws ResumoEducacionalNaoEncontradoException, IdResumoEducacionalObrigatorioException {

        if (Objects.isNull(resumoEducacionalDTO.getIdResumo()))
            throw new IdResumoEducacionalObrigatorioException(Constantes.ID_RESUMO_EDUCACIONAL_OBRIGATORIO);

        final ResumoEducacionalDTO resumoEducacionalConsultado =
                consultarResumoEducacionalPortOut.consultar(resumoEducacionalDTO.getIdResumo());

        resumoEducacionalDTO.setDataCriacao(resumoEducacionalConsultado.getDataCriacao());

        final ResumoEducacionalDTO resumoEducacionalAtualizado =
                atualizarResumoEducacionalPortOut.atualizar(resumoEducacionalDTO);

        log.info("Resumo educacional atualizado com sucesso: {}", resumoEducacionalAtualizado);

        return resumoEducacionalAtualizado;
    }
}