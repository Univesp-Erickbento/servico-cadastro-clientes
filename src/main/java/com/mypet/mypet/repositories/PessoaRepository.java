package com.mypet.mypet.repositories;

import com.mypet.mypet.domain.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    // Método para buscar uma pessoa pelo CPF
    Optional<Pessoa> findByCpf(String cpf);
}
