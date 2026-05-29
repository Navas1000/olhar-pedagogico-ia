package br.com.olharpedagogicoia.adapters.out.funcionario.repository;

import br.com.olharpedagogicoia.adapters.out.funcionario.entity.FuncionarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<FuncionarioEntity, Integer> {
}