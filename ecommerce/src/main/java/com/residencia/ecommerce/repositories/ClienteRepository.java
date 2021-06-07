package com.residencia.ecommerce.repositories;

import com.residencia.ecommerce.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
}
