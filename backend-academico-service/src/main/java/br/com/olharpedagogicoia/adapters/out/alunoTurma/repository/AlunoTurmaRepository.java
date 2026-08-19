package br.com.olharpedagogicoia.adapters.out.alunoTurma.repository;

import br.com.olharpedagogicoia.adapters.out.alunoTurma.entity.AlunoTurmaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlunoTurmaRepository
        extends JpaRepository<AlunoTurmaEntity, Integer> {

    List<AlunoTurmaEntity> findByIdTurma(
            final Integer idTurma
    );
}