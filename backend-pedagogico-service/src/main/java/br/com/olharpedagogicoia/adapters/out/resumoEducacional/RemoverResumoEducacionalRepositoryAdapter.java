package br.com.olharpedagogicoia.adapters.out.resumoEducacional;

import br.com.olharpedagogicoia.adapters.out.resumoEducacional.entity.ResumoEducacionalEntity;
import br.com.olharpedagogicoia.adapters.out.resumoEducacional.repository.ResumoEducacionalRepository;
import br.com.olharpedagogicoia.application.exceptions.Constantes;
import br.com.olharpedagogicoia.application.exceptions.ResumoEducacionalNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.out.RemoverResumoEducacionalPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RemoverResumoEducacionalRepositoryAdapter implements RemoverResumoEducacionalPortOut {

    private final ResumoEducacionalRepository resumoEducacionalRepository;

    @Override
    public void remover(final Integer id) throws ResumoEducacionalNaoEncontradoException {

        final Optional<ResumoEducacionalEntity> resumoEducacionalOpcional =
                resumoEducacionalRepository.findById(id);

        if (resumoEducacionalOpcional.isPresent())
            resumoEducacionalRepository.deleteById(id);
        else
            throw new ResumoEducacionalNaoEncontradoException(Constantes.RESUMO_EDUCACIONAL_NAO_ENCONTRADO);
    }
}