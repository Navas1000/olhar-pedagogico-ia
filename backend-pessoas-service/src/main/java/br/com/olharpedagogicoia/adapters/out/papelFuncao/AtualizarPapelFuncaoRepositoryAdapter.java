package br.com.olharpedagogicoia.adapters.out.papelFuncao;

import br.com.olharpedagogicoia.adapters.out.papelFuncao.entity.PapelFuncaoEntity;
import br.com.olharpedagogicoia.adapters.out.papelFuncao.mapper.PapelFuncaoMapper;
import br.com.olharpedagogicoia.adapters.out.papelFuncao.repository.PapelFuncaoRepository;
import br.com.olharpedagogicoia.application.dto.PapelFuncaoDTO;
import br.com.olharpedagogicoia.application.port.out.AtualizarPapelFuncaoPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AtualizarPapelFuncaoRepositoryAdapter implements AtualizarPapelFuncaoPortOut {

    private final PapelFuncaoRepository papelFuncaoRepository;
    private final PapelFuncaoMapper papelFuncaoMapper;

    @Override
    public PapelFuncaoDTO atualizar(final PapelFuncaoDTO papelFuncaoDTO) {

        final PapelFuncaoEntity papelFuncaoEntity =
                papelFuncaoMapper.dePapelFuncaoDTOParaPapelFuncaoEntity(papelFuncaoDTO);

        final PapelFuncaoEntity papelFuncaoSalvo =
                papelFuncaoRepository.save(papelFuncaoEntity);

        return papelFuncaoMapper.dePapelFuncaoEntityParaPapelFuncaoDTO(papelFuncaoSalvo);
    }
}