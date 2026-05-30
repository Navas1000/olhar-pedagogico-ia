package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.FuncionarioDTO;
import br.com.olharpedagogicoia.application.port.in.CadastrarFuncionarioPortIn;
import br.com.olharpedagogicoia.application.port.out.CadastrarFuncionarioPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
@AllArgsConstructor
public class CadastrarFuncionarioUseCase implements CadastrarFuncionarioPortIn {

    final CadastrarFuncionarioPortOut cadastrarFuncionarioPortOut;

    @Override
    public FuncionarioDTO cadastrar(final FuncionarioDTO funcionarioDTO) {

        funcionarioDTO.setDataModificacao(LocalDateTime.now());
        funcionarioDTO.setDataCriacao(LocalDateTime.now());

        final FuncionarioDTO funcionarioCadastrado = cadastrarFuncionarioPortOut.cadastrar(funcionarioDTO);

        log.info("Funcionário cadastrado com sucesso: {}", funcionarioCadastrado);
        return funcionarioCadastrado;
    }
}