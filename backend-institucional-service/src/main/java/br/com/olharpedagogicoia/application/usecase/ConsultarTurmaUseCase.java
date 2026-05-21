package br.com.olharpedagogicoia.application.usecase;


import br.com.olharpedagogicoia.application.dto.TurmaDto;
import br.com.olharpedagogicoia.application.dto.UnidadeDto;
import br.com.olharpedagogicoia.application.exceptions.TurmaNaoEncontradaException;
import br.com.olharpedagogicoia.application.exceptions.UnidadeNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.in.ConsultarTurmaPortIn;
import br.com.olharpedagogicoia.application.port.in.ConsultarUnidadePortIn;
import br.com.olharpedagogicoia.application.port.out.ConsultarTurmaPortOut;
import br.com.olharpedagogicoia.application.port.out.ConsultarUnidadePortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ConsultarTurmaUseCase implements ConsultarTurmaPortIn {

    final ConsultarTurmaPortOut consultarTurmaPortOut;

    @Override
    public TurmaDto consultar(final Integer id) throws TurmaNaoEncontradaException {

        return consultarTurmaPortOut.consultar(id);



    }
}
