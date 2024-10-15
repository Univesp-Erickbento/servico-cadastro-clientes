package com.mypet.mypet.repositories;

import com.mypet.mypet.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mypet.mypet.domain.core.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa,Long> {

}
