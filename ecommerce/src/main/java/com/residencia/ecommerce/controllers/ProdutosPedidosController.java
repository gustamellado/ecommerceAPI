package com.residencia.ecommerce.controllers;

import com.residencia.ecommerce.entities.Categoria;
import com.residencia.ecommerce.entities.ProdutosPedidos;
import com.residencia.ecommerce.services.ProdutosPedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ProdutosPedidos")
public class ProdutosPedidosController {

    @Autowired
    ProdutosPedidosService produtosPedidosService;

    @GetMapping("/{id}")
    public ResponseEntity<ProdutosPedidos> vizualizarUmProdutoPedido (@PathVariable Integer id){
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(produtosPedidosService.vizualizarUmProdutoPedido(id),headers, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProdutosPedidos>>vizualizarTodosOsProdutosPedidos() throws Exception{

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(produtosPedidosService.vizualizarTodosOsProdutosPedidos(),headers,HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ProdutosPedidos> criarUmNovoPedidoProduto(@RequestBody ProdutosPedidos produtosPedidos){
        HttpHeaders headers = new HttpHeaders();

        if(null != produtosPedidosService.criarUmNovoPedidoProduto(produtosPedidos))
            return new ResponseEntity<ProdutosPedidos>(produtosPedidosService.criarUmNovoPedidoProduto(produtosPedidos), headers, HttpStatus.OK);
        else
            return new ResponseEntity<ProdutosPedidos>(produtosPedidosService.criarUmNovoPedidoProduto(produtosPedidos), headers, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProdutosPedidos> deletarUmProdutoPedido(@PathVariable Integer id){
        HttpHeaders headers = new HttpHeaders();
        boolean isRemoved = produtosPedidosService.deletarUmProdutoPedido(id);
        if (isRemoved){
            return new ResponseEntity<>(headers,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(headers,HttpStatus.BAD_REQUEST);

        }

    }

    @PutMapping("/update")
    public ProdutosPedidos editarUmProdutoPedido(@RequestBody ProdutosPedidos produtosPedidos){

        return produtosPedidosService.editarUmProdutoPedido(produtosPedidos);
    }

}
