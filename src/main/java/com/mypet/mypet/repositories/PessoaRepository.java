package com.mypet.mypet.repositories;

import com.mypet.mypet.application.core.domain.model.PessoasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<PessoasEntity, Long> {

    // Método para buscar uma pessoa pelo CPF
    Optional<PessoasEntity> findByCpf(String cpf);
}
