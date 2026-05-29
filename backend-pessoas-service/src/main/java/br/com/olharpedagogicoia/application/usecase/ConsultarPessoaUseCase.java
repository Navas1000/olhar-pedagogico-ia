package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.PessoaDTO;
import br.com.olharpedagogicoia.application.exceptions.PessoaNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.in.ConsultarPessoaPortIn;
import br.com.olharpedagogicoia.application.port.out.ConsultarPessoaPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class ConsultarPessoaUseCase implements ConsultarPessoaPortIn {

    final ConsultarPessoaPortOut consultarPessoaPortOut;

    @Override
    public PessoaDTO consultar(final Integer id) throws PessoaNaoEncontradaException {

        final PessoaDTO pessoaDTO = consultarPessoaPortOut.consultar(id);

        log.info("Pessoa consultada com sucesso: {}", pessoaDTO);

        return pessoaDTO;
    }
}