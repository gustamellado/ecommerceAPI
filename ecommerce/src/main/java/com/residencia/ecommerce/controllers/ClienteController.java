package com.residencia.ecommerce.controllers;

import com.residencia.ecommerce.entities.Categoria;
import com.residencia.ecommerce.entities.Cliente;
import com.residencia.ecommerce.entities.Pedidos;
import com.residencia.ecommerce.entities.Produto;
import com.residencia.ecommerce.services.CategoriaService;
import com.residencia.ecommerce.services.ClienteService;
import com.residencia.ecommerce.services.PedidosService;
import com.residencia.ecommerce.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Cliente")
public class ClienteController {

    @Autowired
    CategoriaService categoriaService;
    @Autowired
    ClienteService clienteService;
    @Autowired
    ProdutoService produtoService;
    @Autowired
    PedidosService pedidosService;


    /*                                 CLIENTE                      */

    //FALTA COLOCAR ATUALIZAR OS DADOS DO CLIENTE MENOS O CPF FAZER VO

    @DeleteMapping("/delete-conta/{id}")
    public ResponseEntity<Cliente> deletarConta(@RequestParam Integer id){
        HttpHeaders headers = new HttpHeaders();
        boolean isRemoved = clienteService.deletarConta(id);
        if (isRemoved){
            return new ResponseEntity<>(headers,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(headers,HttpStatus.BAD_REQUEST);

        }

    }


    /*                                 CATEGORIAS                   */

//      @GetMapping("/{nomeCategoria}")
//      public ResponseEntity<Categoria> vizualizarUmaCategoria (@PathVariable String nomeCategoria){
//        HttpHeaders headers = new HttpHeaders();
//        return new ResponseEntity<>(categoriaService.vizualizarUmaCategoria(nomeCategoria),headers, HttpStatus.OK);
//    }

    @GetMapping("/vizualizar-categorias")
    public ResponseEntity<List<Categoria>>vizualizarTodasAsCategorias() throws Exception{

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(categoriaService.vizualizarTodasAsCategorias(),headers,HttpStatus.OK);
    }

    @PostMapping("/save-categoria")
    public ResponseEntity<Categoria> criarUmaNovaCategoria(@RequestBody Categoria categoria){
        HttpHeaders headers = new HttpHeaders();

        if(null != categoriaService.criarUmaNovaCategoria(categoria))
            return new ResponseEntity<Categoria>(categoriaService.criarUmaNovaCategoria(categoria), headers, HttpStatus.OK);
        else
            return new ResponseEntity<Categoria>(categoriaService.criarUmaNovaCategoria(categoria), headers, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete-categoria/{categoriaId}")
    public ResponseEntity<Categoria> deletarUmaCategoria(@RequestParam Integer categoriaId){
        HttpHeaders headers = new HttpHeaders();
        boolean isRemoved = categoriaService.deletarUmaCategoria(categoriaId);
        if (isRemoved){
            return new ResponseEntity<>(headers,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(headers,HttpStatus.BAD_REQUEST);

        }

    }

    @PutMapping("editar-categoria")
    public Categoria editarUmaCategoria(@RequestBody Categoria categoria){

        return categoriaService.editarUmaCategoria(categoria);
    }


    /*               PRODUTOS                                                                 */

    @GetMapping("/vizualizar-produtos")
    public ResponseEntity<List<Produto>>vizualizarTodosOsProdutos() throws Exception{

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(produtoService.vizualizarTodosOsProdutos(),headers,HttpStatus.OK);
    }

    @GetMapping("/produtos/count")
    public Long quantidadeDeProdutos() {
        return produtoService.quantidadeDeProdutos();
    }

    @PostMapping("/save-produto")
    public ResponseEntity<Produto> criarUmNovoProduto(@RequestBody Produto produto){
        HttpHeaders headers = new HttpHeaders();

        if(null != produtoService.criarUmNovoProduto(produto))
            return new ResponseEntity<Produto>(produtoService.criarUmNovoProduto(produto), headers, HttpStatus.OK);
        else
            return new ResponseEntity<Produto>(produtoService.criarUmNovoProduto(produto), headers, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete-produto/{produtoId}")
    public ResponseEntity<Produto> excluirUmProduto(@RequestParam Integer produtoId){
        HttpHeaders headers = new HttpHeaders();
        boolean isRemoved = produtoService.excluirUmProduto(produtoId);
        if (isRemoved){
            return new ResponseEntity<>(headers,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(headers,HttpStatus.BAD_REQUEST);

        }

    }

    @PutMapping("/editar-produto")
    public Produto editarUmProduto(@RequestBody Produto produto){

        return produtoService.editarUmProduto(produto);
    }



    /*               PEDIDOS                                                                 */

    @GetMapping("/vizualizar-pedidos")
    public ResponseEntity<List<Pedidos>>vizualizarTodosOsPedidos() throws Exception{

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(pedidosService.vizualizarTodosOsPedidos(),headers,HttpStatus.OK);
    }

    @GetMapping("/pedido/count")
    public Long quantidadeDePedidos() {
        return pedidosService.quantidadeDePedidos();
    }

    @PostMapping("/save-pedidos")
    public ResponseEntity<Pedidos> criarUmNovoPedido(@RequestBody Pedidos pedidos){
        HttpHeaders headers = new HttpHeaders();

        if(null != pedidosService.criarUmNovoPedido(pedidos))
            return new ResponseEntity<Pedidos>(pedidosService.criarUmNovoPedido(pedidos), headers, HttpStatus.OK);
        else
            return new ResponseEntity<Pedidos>(pedidosService.criarUmNovoPedido(pedidos), headers, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete-pedido/{id}")
    public ResponseEntity<Pedidos> excluirUmPedido(@RequestParam Integer id){
        HttpHeaders headers = new HttpHeaders();
        boolean isRemoved = pedidosService.excluirUmPedido(id);
        if (isRemoved){
            return new ResponseEntity<>(headers,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(headers,HttpStatus.BAD_REQUEST);

        }

    }

    @PutMapping("/editar-pedido")
    public Pedidos editarUmPedido(@RequestBody Pedidos pedidos){

        return pedidosService.editarUmPedido(pedidos);
    }





}
