package com.residencia.ecommerce.repositories;

import com.residencia.ecommerce.entities.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidosRepository extends JpaRepository<Pedidos,Integer> {
}
