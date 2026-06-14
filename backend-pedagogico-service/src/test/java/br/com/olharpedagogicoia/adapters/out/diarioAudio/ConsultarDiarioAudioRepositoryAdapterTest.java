package br.com.olharpedagogicoia.adapters.out.diarioAudio;

import br.com.olharpedagogicoia.adapters.out.diarioAudio.entity.DiarioAudioEntity;
import br.com.olharpedagogicoia.adapters.out.diarioAudio.mapper.DiarioAudioMapper;
import br.com.olharpedagogicoia.adapters.out.diarioAudio.repository.DiarioAudioRepository;
import br.com.olharpedagogicoia.application.dto.DiarioAudioDTO;
import br.com.olharpedagogicoia.application.exceptions.DiarioAudioNaoEncontradoException;
import br.com.olharpedagogicoia.application.stub.DiarioAudioStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ConsultarDiarioAudioRepositoryAdapterTest {

    @Mock
    private DiarioAudioRepository diarioAudioRepository;

    @Mock
    private DiarioAudioMapper diarioAudioMapper;

    @InjectMocks
    private ConsultarDiarioAudioRepositoryAdapter consultarDiarioAudioRepositoryAdapter;

    @Test
    void deveConsultarDiarioAudioComSucesso() throws DiarioAudioNaoEncontradoException {

        final Integer idAudio = 1;
        final DiarioAudioDTO diarioAudioDTO = DiarioAudioStub.getDiarioAudioCompleta();
        final DiarioAudioEntity diarioAudioEntity = new DiarioAudioEntity();

        when(diarioAudioRepository.findById(idAudio))
                .thenReturn(Optional.of(diarioAudioEntity));

        when(diarioAudioMapper.deDiarioAudioEntityParaDiarioAudioDTO(diarioAudioEntity))
                .thenReturn(diarioAudioDTO);

        final DiarioAudioDTO resposta =
                consultarDiarioAudioRepositoryAdapter.consultar(idAudio);

        assertNotNull(resposta);
        assertEquals(diarioAudioDTO, resposta);

        verify(diarioAudioRepository).findById(idAudio);
        verify(diarioAudioMapper).deDiarioAudioEntityParaDiarioAudioDTO(diarioAudioEntity);
    }

    @Test
    void deveLancarExcecaoQuandoDiarioAudioNaoForEncontrado() {

        final Integer idAudio = 1;

        when(diarioAudioRepository.findById(idAudio))
                .thenReturn(Optional.empty());

        assertThrows(
                DiarioAudioNaoEncontradoException.class,
                () -> consultarDiarioAudioRepositoryAdapter.consultar(idAudio)
        );

        verify(diarioAudioRepository).findById(idAudio);
        verifyNoInteractions(diarioAudioMapper);
    }
}