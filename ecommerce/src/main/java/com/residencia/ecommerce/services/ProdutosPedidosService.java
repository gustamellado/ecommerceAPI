package com.residencia.ecommerce.services;

import com.residencia.ecommerce.entities.Categoria;
import com.residencia.ecommerce.entities.ProdutosPedidos;
import com.residencia.ecommerce.repositories.ProdutosPedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutosPedidosService {

    @Autowired
    ProdutosPedidosRepository produtosPedidosRepository;

    public ProdutosPedidos vizualizarUmProdutoPedido(Integer id){
        return produtosPedidosRepository.findById(id).get();

        //corrigir, porque nome nao e id, porem nome nao pode repetir
    }

    public List<ProdutosPedidos> vizualizarTodosOsProdutosPedidos(){
        return produtosPedidosRepository.findAll();
    }

    public ProdutosPedidos criarUmNovoPedidoProduto(ProdutosPedidos produtosPedidos){
        ProdutosPedidos novoProdutoPedido = produtosPedidosRepository.save(produtosPedidos);
        return  novoProdutoPedido;
    }

    public boolean deletarUmProdutoPedido(Integer id){
        if(id != null) {
            produtosPedidosRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }

    public ProdutosPedidos editarUmProdutoPedido(ProdutosPedidos produtosPedidos) {
        return produtosPedidosRepository.save(produtosPedidos);
    }


}
