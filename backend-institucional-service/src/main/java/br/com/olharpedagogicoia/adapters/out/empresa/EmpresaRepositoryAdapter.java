package br.com.olharpedagogicoia.adapters.out.empresa;

import br.com.olharpedagogicoia.adapters.out.empresa.entity.EmpresaEntity;
import br.com.olharpedagogicoia.adapters.out.empresa.repository.EmpresaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmpresaRepositoryAdapter {

    EmpresaRepositoryAdapter(EmpresaRepository empresaRepositoryParameter) {
        empresaRepository = empresaRepositoryParameter;
    }

    private final EmpresaRepository empresaRepository;

    @Scheduled(fixedRate = 3000)
    public void testeSomenteVouRemoverNoFuturo(){
        Long id = 2L;
        Optional<EmpresaEntity> empresa = empresaRepository.findById(id);
        System.out.println("Relogio Desparou" + empresa);

    }

}
