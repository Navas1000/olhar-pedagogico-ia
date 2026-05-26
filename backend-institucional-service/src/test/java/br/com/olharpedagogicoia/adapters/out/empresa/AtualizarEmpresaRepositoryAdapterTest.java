package br.com.olharpedagogicoia.adapters.out.empresa;

import br.com.olharpedagogicoia.adapters.out.empresa.entity.EmpresaEntity;
import br.com.olharpedagogicoia.adapters.out.empresa.mapper.EmpresaMapper;
import br.com.olharpedagogicoia.adapters.out.empresa.repository.EmpresaRepository;
import br.com.olharpedagogicoia.application.dto.EmpresaDto;
import br.com.olharpedagogicoia.application.stub.EmpresaStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AtualizarEmpresaRepositoryAdapterTest {

    @Mock
    private EmpresaRepository empresaRepository;

    @Mock
    private EmpresaMapper empresaMapper;

    @InjectMocks
    private AtualizarEmpresaRepositoryAdapter atualizarEmpresaRepositoryAdapter;

    @Test
    void deveAtualizarEmpresaComSucesso() {

        final EmpresaDto empresaDto = EmpresaStub.getEmpresaCompleta();
        final EmpresaEntity empresaEntity = new EmpresaEntity();

        when(empresaMapper.deEmpresaDTOParaEmpresaEntity(empresaDto)).thenReturn(empresaEntity);
        when(empresaRepository.save(empresaEntity)).thenReturn(empresaEntity);
        when(empresaMapper.deEmpresaEntityParaEmpresaDTO(empresaEntity)).thenReturn(empresaDto);

        final EmpresaDto resposta = atualizarEmpresaRepositoryAdapter.atualizar(empresaDto);

        assertNotNull(resposta);
        assertEquals(empresaDto, resposta);

        verify(empresaMapper).deEmpresaDTOParaEmpresaEntity(empresaDto);
        verify(empresaRepository).save(empresaEntity);
        verify(empresaMapper).deEmpresaEntityParaEmpresaDTO(empresaEntity);
    }
}