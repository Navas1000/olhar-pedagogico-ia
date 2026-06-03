package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.AlunoTurmaDTO;
import br.com.olharpedagogicoia.application.port.in.CadastrarAlunoTurmaPortIn;
import br.com.olharpedagogicoia.application.port.out.CadastrarAlunoTurmaPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
@AllArgsConstructor
public class CadastrarAlunoTurmaUseCase implements CadastrarAlunoTurmaPortIn {

    final CadastrarAlunoTurmaPortOut cadastrarAlunoTurmaPortOut;

    @Override
    public AlunoTurmaDTO cadastrar(final AlunoTurmaDTO alunoTurmaDTO) {

        alunoTurmaDTO.setDataCriacao(LocalDateTime.now());

        final AlunoTurmaDTO alunoTurmaCadastrado =
                cadastrarAlunoTurmaPortOut.cadastrar(alunoTurmaDTO);

        log.info("Aluno Turma cadastrado com sucesso: {}", alunoTurmaCadastrado);

        return alunoTurmaCadastrado;
    }
}