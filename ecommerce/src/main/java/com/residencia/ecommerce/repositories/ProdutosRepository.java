package com.residencia.ecommerce.repositories;

import com.residencia.ecommerce.entities.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutosRepository extends JpaRepository<Produtos,Integer> {
}
