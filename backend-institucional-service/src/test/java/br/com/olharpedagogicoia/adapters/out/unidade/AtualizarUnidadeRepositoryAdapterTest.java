package br.com.olharpedagogicoia.adapters.out.unidade;

import br.com.olharpedagogicoia.adapters.out.unidade.entity.UnidadeEntity;
import br.com.olharpedagogicoia.adapters.out.unidade.mapper.UnidadeMapper;
import br.com.olharpedagogicoia.adapters.out.unidade.repository.UnidadeRepository;
import br.com.olharpedagogicoia.application.dto.UnidadeDto;
import br.com.olharpedagogicoia.application.stub.UnidadeStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AtualizarUnidadeRepositoryAdapterTest {

    @Mock
    private UnidadeRepository unidadeRepository;

    @Mock
    private UnidadeMapper unidadeMapper;

    @InjectMocks
    private AtualizarUnidadeRepositoryAdapter atualizarUnidadeRepositoryAdapter;

    @Test
    void deveAtualizarUnidadeComSucesso() {

        final UnidadeDto unidadeDto = UnidadeStub.getUnidadeCompleta();
        final UnidadeEntity unidadeEntity = new UnidadeEntity();

        when(unidadeMapper.deUnidadeDTOParaUnidadeEntity(unidadeDto)).thenReturn(unidadeEntity);
        when(unidadeRepository.save(unidadeEntity)).thenReturn(unidadeEntity);
        when(unidadeMapper.deUnidadeEntityParaUnidadeDTO(unidadeEntity)).thenReturn(unidadeDto);

        final UnidadeDto resposta = atualizarUnidadeRepositoryAdapter.atualizar(unidadeDto);

        assertNotNull(resposta);
        assertEquals(unidadeDto, resposta);

        verify(unidadeMapper).deUnidadeDTOParaUnidadeEntity(unidadeDto);
        verify(unidadeRepository).save(unidadeEntity);
        verify(unidadeMapper).deUnidadeEntityParaUnidadeDTO(unidadeEntity);
    }
}