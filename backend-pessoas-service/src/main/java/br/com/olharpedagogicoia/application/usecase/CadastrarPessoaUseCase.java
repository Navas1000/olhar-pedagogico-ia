package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.PessoaDTO;
import br.com.olharpedagogicoia.application.port.in.CadastrarPessoaPortIn;
import br.com.olharpedagogicoia.application.port.out.CadastrarPessoaPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
@AllArgsConstructor
public class CadastrarPessoaUseCase implements CadastrarPessoaPortIn {

    final CadastrarPessoaPortOut cadastrarPessoaPortOut;

    @Override
    public PessoaDTO cadastrar(final PessoaDTO pessoaDTO) {

        pessoaDTO.setDataModificacao(LocalDateTime.now());
        pessoaDTO.setDataCriacao(LocalDateTime.now());

        final PessoaDTO pessoaCadastrada = cadastrarPessoaPortOut.cadastrar(pessoaDTO);

        log.info("Pessoa cadastrada com sucesso: {}", pessoaCadastrada);
        return pessoaCadastrada;
    }
}