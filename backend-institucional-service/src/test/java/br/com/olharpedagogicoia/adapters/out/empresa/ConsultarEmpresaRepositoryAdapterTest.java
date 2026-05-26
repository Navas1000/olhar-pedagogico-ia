package br.com.olharpedagogicoia.adapters.out.empresa;

import br.com.olharpedagogicoia.adapters.out.empresa.entity.EmpresaEntity;
import br.com.olharpedagogicoia.adapters.out.empresa.mapper.EmpresaMapper;
import br.com.olharpedagogicoia.adapters.out.empresa.repository.EmpresaRepository;
import br.com.olharpedagogicoia.application.dto.EmpresaDto;
import br.com.olharpedagogicoia.application.exceptions.EmpresaNaoEncontradaException;
import br.com.olharpedagogicoia.application.stub.EmpresaStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ConsultarEmpresaRepositoryAdapterTest {

    @Mock
    private EmpresaRepository empresaRepository;

    @Mock
    private EmpresaMapper empresaMapper;

    @InjectMocks
    private ConsultarEmpresaRepositoryAdapter consultarEmpresaRepositoryAdapter;

    @Test
    void deveConsultarEmpresaComSucesso() throws EmpresaNaoEncontradaException {

        final Integer idEmpresa = 1;
        final EmpresaDto empresaDto = EmpresaStub.getEmpresaCompleta();
        final EmpresaEntity empresaEntity = new EmpresaEntity();

        when(empresaRepository.findById(idEmpresa)).thenReturn(Optional.of(empresaEntity));
        when(empresaMapper.deEmpresaEntityParaEmpresaDTO(empresaEntity)).thenReturn(empresaDto);

        final EmpresaDto resposta = consultarEmpresaRepositoryAdapter.consultar(idEmpresa);

        assertNotNull(resposta);
        assertEquals(empresaDto, resposta);

        verify(empresaRepository).findById(idEmpresa);
        verify(empresaMapper).deEmpresaEntityParaEmpresaDTO(empresaEntity);
    }

    @Test
    void deveLancarExcecaoQuandoEmpresaNaoForEncontrada() {

        final Integer idEmpresa = 1;

        when(empresaRepository.findById(idEmpresa)).thenReturn(Optional.empty());

        assertThrows(EmpresaNaoEncontradaException.class,
                () -> consultarEmpresaRepositoryAdapter.consultar(idEmpresa));

        verify(empresaRepository).findById(idEmpresa);
        verifyNoInteractions(empresaMapper);
    }
}