package br.com.olharpedagogicoia.adapters.out.papelFuncao;

import br.com.olharpedagogicoia.adapters.out.papelFuncao.entity.PapelFuncaoEntity;
import br.com.olharpedagogicoia.adapters.out.papelFuncao.mapper.PapelFuncaoMapper;
import br.com.olharpedagogicoia.adapters.out.papelFuncao.repository.PapelFuncaoRepository;
import br.com.olharpedagogicoia.application.dto.PapelFuncaoDTO;
import br.com.olharpedagogicoia.application.exceptions.PapelFuncaoNaoEncontradoException;
import br.com.olharpedagogicoia.application.stub.PapelFuncaoStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ConsultarPapelFuncaoRepositoryAdapterTest {

    @Mock
    private PapelFuncaoRepository papelFuncaoRepository;

    @Mock
    private PapelFuncaoMapper papelFuncaoMapper;

    @InjectMocks
    private ConsultarPapelFuncaoRepositoryAdapter consultarPapelFuncaoRepositoryAdapter;

    @Test
    void deveConsultarPapelFuncaoComSucesso() throws PapelFuncaoNaoEncontradoException {

        final Integer idPapel = 1;
        final PapelFuncaoDTO papelFuncaoDTO = PapelFuncaoStub.getPapelFuncaoCompleta();
        final PapelFuncaoEntity papelFuncaoEntity = new PapelFuncaoEntity();

        when(papelFuncaoRepository.findById(idPapel)).thenReturn(Optional.of(papelFuncaoEntity));
        when(papelFuncaoMapper.dePapelFuncaoEntityParaPapelFuncaoDTO(papelFuncaoEntity)).thenReturn(papelFuncaoDTO);

        final PapelFuncaoDTO resposta = consultarPapelFuncaoRepositoryAdapter.consultar(idPapel);

        assertNotNull(resposta);
        assertEquals(papelFuncaoDTO, resposta);

        verify(papelFuncaoRepository).findById(idPapel);
        verify(papelFuncaoMapper).dePapelFuncaoEntityParaPapelFuncaoDTO(papelFuncaoEntity);
    }

    @Test
    void deveLancarExcecaoQuandoPapelFuncaoNaoForEncontrado() {

        final Integer idPapel = 1;

        when(papelFuncaoRepository.findById(idPapel)).thenReturn(Optional.empty());

        assertThrows(PapelFuncaoNaoEncontradoException.class,
                () -> consultarPapelFuncaoRepositoryAdapter.consultar(idPapel));

        verify(papelFuncaoRepository).findById(idPapel);
        verifyNoInteractions(papelFuncaoMapper);
    }
}