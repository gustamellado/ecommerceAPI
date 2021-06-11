package com.residencia.ecommerce.services;

import java.util.List;

import com.residencia.ecommerce.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.ecommerce.entities.Categoria;


@Service
public class CategoriaService {

    @Autowired
    public CategoriaRepository categoriaRepository;

    public Categoria vizualizarUmaCategoria(String categoria){
        return categoriaRepository.findByNomeCategoria(categoria);

        //corrigir, porque nome nao e id, porem nome nao pode repetir
    }

    public List<Categoria> vizualizarTodasAsCategorias(){
        return categoriaRepository.findAll();
    }

//    public Long Count() {
//        return categoriaRepository.count();
//    }

    public Categoria criarUmaNovaCategoria(Categoria categoria){
        Categoria novaCategoria = categoriaRepository.save(categoria);
        return  novaCategoria;
    }

    public boolean deletarUmaCategoria(Integer categoriaId){
        if(categoriaId != null) {
            categoriaRepository.deleteById(categoriaId);
            return true;
        }
        else {
            return false;
        }
    }

    public Categoria editarUmaCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

}