package com.mypet.mypet.repositories;

import com.mypet.mypet.core.entities.Pessoas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Pessoas,Long> {
}
