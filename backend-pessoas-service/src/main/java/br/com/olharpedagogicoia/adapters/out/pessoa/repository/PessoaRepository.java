package br.com.olharpedagogicoia.adapters.out.pessoa.repository;

import br.com.olharpedagogicoia.adapters.out.pessoa.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {
}