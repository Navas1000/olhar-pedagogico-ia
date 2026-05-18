package br.com.olharpedagogicoia.application.usecase;


import br.com.olharpedagogicoia.application.dto.UnidadeDto;
import br.com.olharpedagogicoia.application.exceptions.UnidadeNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.in.ConsultarUnidadePortIn;
import br.com.olharpedagogicoia.application.port.out.ConsultarUnidadePortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ConsultarUnidadeUseCase implements ConsultarUnidadePortIn {

    final ConsultarUnidadePortOut consultarUnidadePortOut;

    @Override
    public UnidadeDto consultar(final Integer id) throws UnidadeNaoEncontradaException {

        return consultarUnidadePortOut.consultar(id);



    }
}
