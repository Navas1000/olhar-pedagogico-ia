package br.com.olharpedagogicoia.adapters.out.empresa.repository;

import br.com.olharpedagogicoia.adapters.out.empresa.entity.EmpresaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<EmpresaEntity, Long> {
}
