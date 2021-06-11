package com.residencia.ecommerce.repositories;

import com.residencia.ecommerce.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,Integer> {

    Produto findByNome(String nome);
}
