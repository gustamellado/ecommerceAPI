package com.residencia.ecommerce.repositories;

import com.residencia.ecommerce.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria,Integer> {

//    Categoria findByName(String nomeCategoria);
}
