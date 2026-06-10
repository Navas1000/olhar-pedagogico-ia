package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.FuncionarioDTO;
import br.com.olharpedagogicoia.application.exceptions.FuncionarioNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.in.ConsultarFuncionarioPortIn;
import br.com.olharpedagogicoia.application.port.out.ConsultarFuncionarioPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class ConsultarFuncionarioUseCase implements ConsultarFuncionarioPortIn {

    final ConsultarFuncionarioPortOut consultarFuncionarioPortOut;

    @Override
    public FuncionarioDTO consultar(final Integer id) throws FuncionarioNaoEncontradoException {

        final FuncionarioDTO funcionarioDTO = consultarFuncionarioPortOut.consultar(id);

        funcionarioDTO.setSenha(null);

        log.info("Funcionário consultado com sucesso: {}", funcionarioDTO);

        return funcionarioDTO;
    }
}