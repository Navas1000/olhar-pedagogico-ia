package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.PessoaDTO;
import br.com.olharpedagogicoia.application.exceptions.Constantes;
import br.com.olharpedagogicoia.application.exceptions.IdPessoaObrigatorioException;
import br.com.olharpedagogicoia.application.exceptions.PessoaNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.in.AtualizarPessoaPortIn;
import br.com.olharpedagogicoia.application.port.out.AtualizarPessoaPortOut;
import br.com.olharpedagogicoia.application.port.out.ConsultarPessoaPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;

@Slf4j
@Component
@AllArgsConstructor
public class AtualizarPessoaUseCase implements AtualizarPessoaPortIn {

    final AtualizarPessoaPortOut atualizarPessoaPortOut;
    final ConsultarPessoaPortOut consultarPessoaPortOut;

    @Override
    public PessoaDTO atualizar(final PessoaDTO pessoaDTO) throws PessoaNaoEncontradaException, IdPessoaObrigatorioException {

        if (Objects.isNull(pessoaDTO.getIdPessoa()))
            throw new IdPessoaObrigatorioException(Constantes.ID_PESSOA_OBRIGATORIO);

        final PessoaDTO pessoaConsultada = consultarPessoaPortOut.consultar(pessoaDTO.getIdPessoa());

        pessoaDTO.setDataCriacao(pessoaConsultada.getDataCriacao());
        pessoaDTO.setDataModificacao(LocalDateTime.now());

        final PessoaDTO pessoaAtualizada = atualizarPessoaPortOut.atualizar(pessoaDTO);

        log.info("Pessoa atualizada com sucesso: {}", pessoaAtualizada);
        return pessoaAtualizada;
    }
}