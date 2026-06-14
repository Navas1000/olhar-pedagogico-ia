package br.com.olharpedagogicoia.adapters.out.transcricao;

import br.com.olharpedagogicoia.adapters.out.transcricao.entity.TranscricaoEntity;
import br.com.olharpedagogicoia.adapters.out.transcricao.mapper.TranscricaoMapper;
import br.com.olharpedagogicoia.adapters.out.transcricao.repository.TranscricaoRepository;
import br.com.olharpedagogicoia.application.dto.TranscricaoDTO;
import br.com.olharpedagogicoia.application.stub.TranscricaoStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CadastrarTranscricaoRepositoryAdapterTest {

    @Mock
    private TranscricaoRepository transcricaoRepository;

    @Mock
    private TranscricaoMapper transcricaoMapper;

    @InjectMocks
    private CadastrarTranscricaoRepositoryAdapter cadastrarTranscricaoRepositoryAdapter;

    @Test
    void deveCadastrarTranscricaoComSucesso() {

        final TranscricaoDTO transcricaoDTO = TranscricaoStub.getTranscricaoCompleta();
        final TranscricaoEntity transcricaoEntity = new TranscricaoEntity();

        when(transcricaoMapper.deTranscricaoDTOParaTranscricaoEntity(transcricaoDTO))
                .thenReturn(transcricaoEntity);

        when(transcricaoRepository.save(transcricaoEntity))
                .thenReturn(transcricaoEntity);

        when(transcricaoMapper.deTranscricaoEntityParaTranscricaoDTO(transcricaoEntity))
                .thenReturn(transcricaoDTO);

        final TranscricaoDTO resposta =
                cadastrarTranscricaoRepositoryAdapter.cadastrar(transcricaoDTO);

        assertNotNull(resposta);
        assertEquals(transcricaoDTO, resposta);

        verify(transcricaoMapper).deTranscricaoDTOParaTranscricaoEntity(transcricaoDTO);
        verify(transcricaoRepository).save(transcricaoEntity);
        verify(transcricaoMapper).deTranscricaoEntityParaTranscricaoDTO(transcricaoEntity);
    }
}