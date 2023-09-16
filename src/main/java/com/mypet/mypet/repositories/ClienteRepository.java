package com.mypet.mypet.repositories;

import com.mypet.mypet.domain.model.Pessoas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Pessoas,Long> {
}
