package br.com.olharpedagogicoia.adapters.out.papelFuncao;

import br.com.olharpedagogicoia.adapters.out.papelFuncao.entity.PapelFuncaoEntity;
import br.com.olharpedagogicoia.adapters.out.papelFuncao.repository.PapelFuncaoRepository;
import br.com.olharpedagogicoia.application.exceptions.Constantes;
import br.com.olharpedagogicoia.application.exceptions.PapelFuncaoNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.out.RemoverPapelFuncaoPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RemoverPapelFuncaoRepositoryAdapter implements RemoverPapelFuncaoPortOut {

    private final PapelFuncaoRepository papelFuncaoRepository;

    @Override
    public void remover(final Integer id) throws PapelFuncaoNaoEncontradoException {

        final Optional<PapelFuncaoEntity> papelFuncaoOpcional = papelFuncaoRepository.findById(id);

        if (papelFuncaoOpcional.isPresent())
            papelFuncaoRepository.deleteById(id);
        else
            throw new PapelFuncaoNaoEncontradoException(Constantes.PAPEL_FUNCAO_NAO_ENCONTRADO);
    }
}