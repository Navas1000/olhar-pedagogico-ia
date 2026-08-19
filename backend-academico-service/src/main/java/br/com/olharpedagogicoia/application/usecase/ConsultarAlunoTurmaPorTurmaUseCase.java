package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.AlunoTurmaDTO;
import br.com.olharpedagogicoia.application.port.in.ConsultarAlunoTurmaPorTurmaPortIn;
import br.com.olharpedagogicoia.application.port.out.ConsultarAlunoTurmaPorTurmaPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ConsultarAlunoTurmaPorTurmaUseCase
        implements ConsultarAlunoTurmaPorTurmaPortIn {

    private final ConsultarAlunoTurmaPorTurmaPortOut
            consultarAlunoTurmaPorTurmaPortOut;

    @Override
    public List<AlunoTurmaDTO> consultarPorTurma(
            final Integer idTurma) {

        return consultarAlunoTurmaPorTurmaPortOut
                .consultarPorTurma(idTurma);
    }
}