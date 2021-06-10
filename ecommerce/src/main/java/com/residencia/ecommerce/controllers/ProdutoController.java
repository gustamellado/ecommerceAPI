package com.residencia.ecommerce.controllers;

import com.residencia.ecommerce.entities.Produto;
import com.residencia.ecommerce.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    ProdutoService produtoService;

    @GetMapping("/vizualizar-produtos")
    public ResponseEntity<List<Produto>> vizualizarTodosOsProdutos() throws Exception{

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(produtoService.vizualizarTodosOsProdutos(),headers, HttpStatus.OK);
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
    public ResponseEntity<Produto> excluirUmProduto(@PathVariable Integer produtoId){
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

}
