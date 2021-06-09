package com.residencia.ecommerce.repositories;

import com.residencia.ecommerce.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutosRepository extends JpaRepository<Produto,Integer> {
}
