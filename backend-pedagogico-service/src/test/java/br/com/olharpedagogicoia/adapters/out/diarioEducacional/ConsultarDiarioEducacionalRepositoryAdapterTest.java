package br.com.olharpedagogicoia.adapters.out.diarioEducacional;

import br.com.olharpedagogicoia.adapters.out.diarioEducacional.entity.DiarioEducacionalEntity;
import br.com.olharpedagogicoia.adapters.out.diarioEducacional.mapper.DiarioEducacionalMapper;
import br.com.olharpedagogicoia.adapters.out.diarioEducacional.repository.DiarioEducacionalRepository;
import br.com.olharpedagogicoia.application.dto.DiarioEducacionalDTO;
import br.com.olharpedagogicoia.application.exceptions.DiarioEducacionalNaoEncontradoException;
import br.com.olharpedagogicoia.application.stub.DiarioEducacionalStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ConsultarDiarioEducacionalRepositoryAdapterTest {

    @Mock
    private DiarioEducacionalRepository diarioEducacionalRepository;

    @Mock
    private DiarioEducacionalMapper diarioEducacionalMapper;

    @InjectMocks
    private ConsultarDiarioEducacionalRepositoryAdapter consultarDiarioEducacionalRepositoryAdapter;

    @Test
    void deveConsultarDiarioEducacionalComSucesso() throws DiarioEducacionalNaoEncontradoException {

        final Integer idDiario = 1;
        final DiarioEducacionalDTO diarioEducacionalDTO = DiarioEducacionalStub.getDiarioEducacionalCompleta();
        final DiarioEducacionalEntity diarioEducacionalEntity = new DiarioEducacionalEntity();

        when(diarioEducacionalRepository.findById(idDiario))
                .thenReturn(Optional.of(diarioEducacionalEntity));

        when(diarioEducacionalMapper.deDiarioEducacionalEntityParaDiarioEducacionalDTO(diarioEducacionalEntity))
                .thenReturn(diarioEducacionalDTO);

        final DiarioEducacionalDTO resposta =
                consultarDiarioEducacionalRepositoryAdapter.consultar(idDiario);

        assertNotNull(resposta);
        assertEquals(diarioEducacionalDTO, resposta);

        verify(diarioEducacionalRepository).findById(idDiario);
        verify(diarioEducacionalMapper).deDiarioEducacionalEntityParaDiarioEducacionalDTO(diarioEducacionalEntity);
    }

    @Test
    void deveLancarExcecaoQuandoDiarioEducacionalNaoForEncontrado() {

        final Integer idDiario = 1;

        when(diarioEducacionalRepository.findById(idDiario))
                .thenReturn(Optional.empty());

        assertThrows(
                DiarioEducacionalNaoEncontradoException.class,
                () -> consultarDiarioEducacionalRepositoryAdapter.consultar(idDiario)
        );

        verify(diarioEducacionalRepository).findById(idDiario);
        verifyNoInteractions(diarioEducacionalMapper);
    }
}