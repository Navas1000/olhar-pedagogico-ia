package br.com.olharpedagogicoia.adapters.out.diarioAudio;

import br.com.olharpedagogicoia.adapters.out.diarioAudio.entity.DiarioAudioEntity;
import br.com.olharpedagogicoia.adapters.out.diarioAudio.mapper.DiarioAudioMapper;
import br.com.olharpedagogicoia.adapters.out.diarioAudio.repository.DiarioAudioRepository;
import br.com.olharpedagogicoia.application.dto.DiarioAudioDTO;
import br.com.olharpedagogicoia.application.stub.DiarioAudioStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CadastrarDiarioAudioRepositoryAdapterTest {

    @Mock
    private DiarioAudioRepository diarioAudioRepository;

    @Mock
    private DiarioAudioMapper diarioAudioMapper;

    @InjectMocks
    private CadastrarDiarioAudioRepositoryAdapter cadastrarDiarioAudioRepositoryAdapter;

    @Test
    void deveCadastrarDiarioAudioComSucesso() {

        final DiarioAudioDTO diarioAudioDTO = DiarioAudioStub.getDiarioAudioCompleta();
        final DiarioAudioEntity diarioAudioEntity = new DiarioAudioEntity();

        when(diarioAudioMapper.deDiarioAudioDTOParaDiarioAudioEntity(diarioAudioDTO))
                .thenReturn(diarioAudioEntity);

        when(diarioAudioRepository.save(diarioAudioEntity))
                .thenReturn(diarioAudioEntity);

        when(diarioAudioMapper.deDiarioAudioEntityParaDiarioAudioDTO(diarioAudioEntity))
                .thenReturn(diarioAudioDTO);

        final DiarioAudioDTO resposta =
                cadastrarDiarioAudioRepositoryAdapter.cadastrar(diarioAudioDTO);

        assertNotNull(resposta);
        assertEquals(diarioAudioDTO, resposta);

        verify(diarioAudioMapper).deDiarioAudioDTOParaDiarioAudioEntity(diarioAudioDTO);
        verify(diarioAudioRepository).save(diarioAudioEntity);
        verify(diarioAudioMapper).deDiarioAudioEntityParaDiarioAudioDTO(diarioAudioEntity);
    }
}