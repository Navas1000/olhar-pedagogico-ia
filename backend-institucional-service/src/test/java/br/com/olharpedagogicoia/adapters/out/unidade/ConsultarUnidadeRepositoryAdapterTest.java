package br.com.olharpedagogicoia.adapters.out.unidade;

import br.com.olharpedagogicoia.adapters.out.unidade.entity.UnidadeEntity;
import br.com.olharpedagogicoia.adapters.out.unidade.mapper.UnidadeMapper;
import br.com.olharpedagogicoia.adapters.out.unidade.repository.UnidadeRepository;
import br.com.olharpedagogicoia.application.dto.UnidadeDto;
import br.com.olharpedagogicoia.application.exceptions.UnidadeNaoEncontradaException;
import br.com.olharpedagogicoia.application.stub.UnidadeStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ConsultarUnidadeRepositoryAdapterTest {

    @Mock
    private UnidadeRepository unidadeRepository;

    @Mock
    private UnidadeMapper unidadeMapper;

    @InjectMocks
    private ConsultarUnidadeRepositoryAdapter consultarUnidadeRepositoryAdapter;

    @Test
    void deveConsultarUnidadeComSucesso() throws UnidadeNaoEncontradaException {

        final Integer idUnidade = 1;
        final UnidadeDto unidadeDto = UnidadeStub.getUnidadeCompleta();
        final UnidadeEntity unidadeEntity = new UnidadeEntity();

        when(unidadeRepository.findById(idUnidade)).thenReturn(Optional.of(unidadeEntity));
        when(unidadeMapper.deUnidadeEntityParaUnidadeDTO(unidadeEntity)).thenReturn(unidadeDto);

        final UnidadeDto resposta = consultarUnidadeRepositoryAdapter.consultar(idUnidade);

        assertNotNull(resposta);
        assertEquals(unidadeDto, resposta);

        verify(unidadeRepository).findById(idUnidade);
        verify(unidadeMapper).deUnidadeEntityParaUnidadeDTO(unidadeEntity);
    }

    @Test
    void deveLancarExcecaoQuandoUnidadeNaoForEncontrada() {

        final Integer idUnidade = 1;

        when(unidadeRepository.findById(idUnidade)).thenReturn(Optional.empty());

        assertThrows(UnidadeNaoEncontradaException.class,
                () -> consultarUnidadeRepositoryAdapter.consultar(idUnidade));

        verify(unidadeRepository).findById(idUnidade);
        verifyNoInteractions(unidadeMapper);
    }
}