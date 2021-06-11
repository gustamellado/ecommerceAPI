package com.residencia.ecommerce.services;

import java.util.List;

import com.residencia.ecommerce.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.ecommerce.entities.Produto;

@Service
public class ProdutoService {

    @Autowired
    public ProdutoRepository produtoRepository;

    public Produto vizualizarUmProduto(String nome){
        return produtoRepository.findByNome(nome);

    }

    public List<Produto> vizualizarTodosOsProdutos(){
        return produtoRepository.findAll();
    }

    public Long quantidadeDeProdutos() {
        return produtoRepository.count();
    }

    public Produto criarUmNovoProduto(Produto produto){
        Produto novoProduto = produtoRepository.save(produto);
        return  novoProduto;

        // com imagem
    }

    public boolean excluirUmProduto(Integer produtoId){
        if(produtoId != null) {
            produtoRepository.deleteById(produtoId);
            return true;
        }
        else {
            return false;
        }
    }

    public Produto editarUmProduto(Produto produto) {
        return produtoRepository.save(produto);
    }



}
