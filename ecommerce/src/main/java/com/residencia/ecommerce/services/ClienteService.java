package com.residencia.ecommerce.services;

import java.util.List;

import com.residencia.ecommerce.repositories.CategoriaRepository;
import com.residencia.ecommerce.repositories.ClienteRepository;
import com.residencia.ecommerce.repositories.PedidosRepository;
import com.residencia.ecommerce.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.ecommerce.entities.Categoria;
import com.residencia.ecommerce.entities.Cliente;
import com.residencia.ecommerce.entities.Pedidos;
import com.residencia.ecommerce.entities.Produto;

@Service
public class ClienteService {

    @Autowired
    public ClienteRepository clienteRepository;
    @Autowired
    public PedidosRepository pedidosRepository;
    @Autowired
    public CategoriaRepository categoriaRepository;
    @Autowired
    public ProdutoRepository produtoRepository;


    //FAZER PELO VO
    public Cliente atualizarDadosPessoais(Cliente Cliente) {
        return clienteRepository.save(Cliente);
        // cpf nao

    }

    public boolean deletarConta(Integer id){
        if(id != null) {
            clienteRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }


    }

    /*  PEDIDOS                                                           */
    public Pedidos criarUmNovoPedido(Pedidos pedidos){
        Pedidos novoPedido = pedidosRepository.save(pedidos);
        return  novoPedido;

    }

    public Pedidos editarUmPedido(Pedidos pedidos) {
        return pedidosRepository.save(pedidos);

    }

    public List<Pedidos> vizualizarTodosOsPedidos(){
        return pedidosRepository.findAll();
    }

    public boolean excluirUmPedido(Integer id){
        if(id != null) {
            pedidosRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }

    //public Pedidos editarUmPedidoParaFinalizado(Pedidos pedidos)

    //public Pedidos FinalizarPedido(Pedidos pedidos)

//    public Categoria vizualizarUmaCategoria(String nomecategoria){
//        return categoriaRepository.findByName(nomecategoria);
//
//        //corrigir, porque nome nao e id, porem nome nao pode repetir
//
//    }



/*            CATEGORIA                                     */
//    public Categoria vizualizarUmaCategoria(String nomeCategoria){
//        return categoriaRepository.findByName(nomeCategoria);
//
//        //corrigir, porque nome nao e id, porem nome nao pode repetir
//    }

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

    public boolean deletarUmaCategoria(Integer id){
        if(id != null) {
            categoriaRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }

    public Categoria editarUmaCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }





/*            PRODUTO                                              */
//    public Produto vizualizarUmProduto(String nome){
//        return produtoRepository.findByName(nome);
//        //corrigir, porque nome nao e id, porem nome nao pode repetir
//    }

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

    public boolean excluirUmProduto(Integer id){
        if(id != null) {
            produtoRepository.deleteById(id);
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

