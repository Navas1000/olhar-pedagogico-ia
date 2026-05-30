package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.PapelFuncaoDTO;
import br.com.olharpedagogicoia.application.exceptions.Constantes;
import br.com.olharpedagogicoia.application.exceptions.IdPapelFuncaoObrigatorioException;
import br.com.olharpedagogicoia.application.exceptions.PapelFuncaoNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.in.AtualizarPapelFuncaoPortIn;
import br.com.olharpedagogicoia.application.port.out.AtualizarPapelFuncaoPortOut;
import br.com.olharpedagogicoia.application.port.out.ConsultarPapelFuncaoPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;

@Slf4j
@Component
@AllArgsConstructor
public class AtualizarPapelFuncaoUseCase implements AtualizarPapelFuncaoPortIn {

    final AtualizarPapelFuncaoPortOut atualizarPapelFuncaoPortOut;
    final ConsultarPapelFuncaoPortOut consultarPapelFuncaoPortOut;

    @Override
    public PapelFuncaoDTO atualizar(final PapelFuncaoDTO papelFuncaoDTO) throws PapelFuncaoNaoEncontradoException, IdPapelFuncaoObrigatorioException {

        if (Objects.isNull(papelFuncaoDTO.getIdPapel()))
            throw new IdPapelFuncaoObrigatorioException(Constantes.ID_PAPEL_FUNCAO_OBRIGATORIO);

        final PapelFuncaoDTO papelFuncaoConsultado = consultarPapelFuncaoPortOut.consultar(papelFuncaoDTO.getIdPapel());

        papelFuncaoDTO.setDataCriacao(papelFuncaoConsultado.getDataCriacao());
        papelFuncaoDTO.setDataModificacao(LocalDateTime.now());

        final PapelFuncaoDTO papelFuncaoAtualizado = atualizarPapelFuncaoPortOut.atualizar(papelFuncaoDTO);

        log.info("Papel Função atualizado com sucesso: {}", papelFuncaoAtualizado);
        return papelFuncaoAtualizado;
    }
}