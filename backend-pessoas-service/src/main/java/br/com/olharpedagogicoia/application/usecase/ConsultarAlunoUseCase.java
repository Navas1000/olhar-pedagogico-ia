package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.AlunoDTO;
import br.com.olharpedagogicoia.application.exceptions.AlunoNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.in.ConsultarAlunoPortIn;
import br.com.olharpedagogicoia.application.port.out.ConsultarAlunoPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class ConsultarAlunoUseCase implements ConsultarAlunoPortIn {

    final ConsultarAlunoPortOut consultarAlunoPortOut;

    @Override
    public AlunoDTO consultar(final Integer id) throws AlunoNaoEncontradoException {

        final AlunoDTO alunoDTO = consultarAlunoPortOut.consultar(id);

        log.info("Aluno consultado com sucesso: {}", alunoDTO);

        return alunoDTO;
    }
}