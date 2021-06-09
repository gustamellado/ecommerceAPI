package com.residencia.ecommerce.repositories;

import com.residencia.ecommerce.entities.ProdutosPedidos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Produtos_PedidosRepository extends JpaRepository<ProdutosPedidos,Integer> {
}
