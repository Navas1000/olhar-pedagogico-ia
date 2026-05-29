package br.com.olharpedagogicoia.adapters.out.papelFuncao;

import br.com.olharpedagogicoia.adapters.out.papelFuncao.entity.PapelFuncaoEntity;
import br.com.olharpedagogicoia.adapters.out.papelFuncao.mapper.PapelFuncaoMapper;
import br.com.olharpedagogicoia.adapters.out.papelFuncao.repository.PapelFuncaoRepository;
import br.com.olharpedagogicoia.application.dto.PapelFuncaoDTO;
import br.com.olharpedagogicoia.application.exceptions.Constantes;
import br.com.olharpedagogicoia.application.exceptions.PapelFuncaoNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.out.ConsultarPapelFuncaoPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ConsultarPapelFuncaoRepositoryAdapter implements ConsultarPapelFuncaoPortOut {

    private final PapelFuncaoRepository papelFuncaoRepository;
    private final PapelFuncaoMapper papelFuncaoMapper;

    @Override
    public PapelFuncaoDTO consultar(final Integer id) throws PapelFuncaoNaoEncontradoException {

        final Optional<PapelFuncaoEntity> papelFuncaoOpcional = papelFuncaoRepository.findById(id);

        if (papelFuncaoOpcional.isPresent())
            return papelFuncaoMapper.dePapelFuncaoEntityParaPapelFuncaoDTO(papelFuncaoOpcional.get());

        throw new PapelFuncaoNaoEncontradoException(Constantes.PAPEL_FUNCAO_NAO_ENCONTRADO);
    }
}