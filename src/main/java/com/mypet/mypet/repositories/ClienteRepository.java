package com.mypet.mypet.repositories;

import com.mypet.mypet.application.core.domain.model.ClientesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<ClientesEntity, Long> {

    Optional<ClientesEntity> findByPessoaId(Long pessoaId);
}
