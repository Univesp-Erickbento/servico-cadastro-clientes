package com.mypet.mypet.repositories;

import com.mypet.mypet.domain.model.Funcionarios;
import com.mypet.mypet.domain.model.Pessoas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionarios,Long> {

}
