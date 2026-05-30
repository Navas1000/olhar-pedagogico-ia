package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.AlunoDTO;
import br.com.olharpedagogicoia.application.exceptions.AlunoNaoEncontradoException;
import br.com.olharpedagogicoia.application.exceptions.Constantes;
import br.com.olharpedagogicoia.application.exceptions.IdAlunoObrigatorioException;
import br.com.olharpedagogicoia.application.port.in.AtualizarAlunoPortIn;
import br.com.olharpedagogicoia.application.port.out.AtualizarAlunoPortOut;
import br.com.olharpedagogicoia.application.port.out.ConsultarAlunoPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;

@Slf4j
@Component
@AllArgsConstructor
public class AtualizarAlunoUseCase implements AtualizarAlunoPortIn {

    final AtualizarAlunoPortOut atualizarAlunoPortOut;
    final ConsultarAlunoPortOut consultarAlunoPortOut;

    @Override
    public AlunoDTO atualizar(final AlunoDTO alunoDTO) throws AlunoNaoEncontradoException, IdAlunoObrigatorioException {

        if (Objects.isNull(alunoDTO.getIdAluno()))
            throw new IdAlunoObrigatorioException(Constantes.ID_ALUNO_OBRIGATORIO);

        final AlunoDTO alunoConsultado = consultarAlunoPortOut.consultar(alunoDTO.getIdAluno());

        alunoDTO.setDataCriacao(alunoConsultado.getDataCriacao());
        alunoDTO.setDataModificacao(LocalDateTime.now());

        final AlunoDTO alunoAtualizado = atualizarAlunoPortOut.atualizar(alunoDTO);

        log.info("Aluno atualizado com sucesso: {}", alunoAtualizado);
        return alunoAtualizado;
    }
}