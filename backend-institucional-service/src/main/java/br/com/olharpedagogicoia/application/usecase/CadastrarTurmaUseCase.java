package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.TurmaDto;
import br.com.olharpedagogicoia.application.port.in.CadastrarTurmaPortIn;
import br.com.olharpedagogicoia.application.port.out.CadastrarTurmaPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
@AllArgsConstructor
public class CadastrarTurmaUseCase implements CadastrarTurmaPortIn {

    final CadastrarTurmaPortOut cadastrarTurmaPortOut;

    @Override
    public TurmaDto cadastrar(final TurmaDto turmaDto) {

        turmaDto.setDataModificacao(LocalDateTime.now());
        turmaDto.setDataCriacao(LocalDateTime.now());

        TurmaDto cadastrarTurma = cadastrarTurmaPortOut.cadastrar(turmaDto);
        log.info("Turma cadastrada com sucesso: {}", cadastrarTurma);
        return cadastrarTurma;
    }
}