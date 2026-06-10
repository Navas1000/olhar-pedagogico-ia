package br.com.olharpedagogicoia.adapters.out.funcionario.repository;

import br.com.olharpedagogicoia.adapters.out.funcionario.entity.FuncionarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<FuncionarioEntity, Integer> {
    Optional<FuncionarioEntity> findByNomeUsuarioAndSenha(final String nomeUsuario, final String senha);
}