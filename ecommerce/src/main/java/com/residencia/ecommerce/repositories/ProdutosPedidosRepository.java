package com.residencia.ecommerce.repositories;

import com.residencia.ecommerce.entities.Pedidos;
import com.residencia.ecommerce.entities.Produto;
import com.residencia.ecommerce.entities.ProdutosPedidos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutosPedidosRepository extends JpaRepository<ProdutosPedidos,Integer> {
    List<ProdutosPedidos> FindByPedido(Pedidos pedidos);
}
