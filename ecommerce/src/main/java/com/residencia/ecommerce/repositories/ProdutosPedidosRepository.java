package com.residencia.ecommerce.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.residencia.ecommerce.entities.Pedidos;
import com.residencia.ecommerce.entities.ProdutosPedidos;

@Repository
public interface ProdutosPedidosRepository extends JpaRepository<ProdutosPedidos,Integer> {
   
}
