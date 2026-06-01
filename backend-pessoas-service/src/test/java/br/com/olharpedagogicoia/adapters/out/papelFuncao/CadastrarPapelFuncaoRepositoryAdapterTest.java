package br.com.olharpedagogicoia.adapters.out.papelFuncao;

import br.com.olharpedagogicoia.adapters.out.papelFuncao.entity.PapelFuncaoEntity;
import br.com.olharpedagogicoia.adapters.out.papelFuncao.mapper.PapelFuncaoMapper;
import br.com.olharpedagogicoia.adapters.out.papelFuncao.repository.PapelFuncaoRepository;
import br.com.olharpedagogicoia.application.dto.PapelFuncaoDTO;
import br.com.olharpedagogicoia.application.stub.PapelFuncaoStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CadastrarPapelFuncaoRepositoryAdapterTest {

    @Mock
    private PapelFuncaoRepository papelFuncaoRepository;

    @Mock
    private PapelFuncaoMapper papelFuncaoMapper;

    @InjectMocks
    private CadastrarPapelFuncaoRepositoryAdapter cadastrarPapelFuncaoRepositoryAdapter;

    @Test
    void deveCadastrarPapelFuncaoComSucesso() {

        final PapelFuncaoDTO papelFuncaoDTO = PapelFuncaoStub.getPapelFuncaoCompleta();
        final PapelFuncaoEntity papelFuncaoEntity = new PapelFuncaoEntity();

        when(papelFuncaoMapper.dePapelFuncaoDTOParaPapelFuncaoEntity(papelFuncaoDTO)).thenReturn(papelFuncaoEntity);
        when(papelFuncaoRepository.save(papelFuncaoEntity)).thenReturn(papelFuncaoEntity);
        when(papelFuncaoMapper.dePapelFuncaoEntityParaPapelFuncaoDTO(papelFuncaoEntity)).thenReturn(papelFuncaoDTO);

        final PapelFuncaoDTO resposta = cadastrarPapelFuncaoRepositoryAdapter.cadastrar(papelFuncaoDTO);

        assertNotNull(resposta);
        assertEquals(papelFuncaoDTO, resposta);

        verify(papelFuncaoMapper).dePapelFuncaoDTOParaPapelFuncaoEntity(papelFuncaoDTO);
        verify(papelFuncaoRepository).save(papelFuncaoEntity);
        verify(papelFuncaoMapper).dePapelFuncaoEntityParaPapelFuncaoDTO(papelFuncaoEntity);
    }
}