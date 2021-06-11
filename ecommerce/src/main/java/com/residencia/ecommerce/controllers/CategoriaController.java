package com.residencia.ecommerce.controllers;

import com.residencia.ecommerce.entities.Categoria;
import com.residencia.ecommerce.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/{categoria}")
    public ResponseEntity<Categoria> vizualizarUmaCategoria (@PathVariable String categoria){
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(categoriaService.vizualizarUmaCategoria(categoria),headers, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Categoria>>vizualizarTodasAsCategorias() throws Exception{

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(categoriaService.vizualizarTodasAsCategorias(),headers,HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Categoria> save(@RequestBody Categoria categoria){
        HttpHeaders headers = new HttpHeaders();

        if(null != categoriaService.criarUmaNovaCategoria(categoria))
            return new ResponseEntity<Categoria>(categoriaService.criarUmaNovaCategoria(categoria), headers, HttpStatus.OK);
        else
            return new ResponseEntity<Categoria>(categoriaService.criarUmaNovaCategoria(categoria), headers, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Categoria> deletarUmaCategoria(@PathVariable Integer id){
        HttpHeaders headers = new HttpHeaders();
        boolean isRemoved = categoriaService.deletarUmaCategoria(id);
        if (isRemoved){
            return new ResponseEntity<>(headers,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(headers,HttpStatus.BAD_REQUEST);

        }

    }

    @PutMapping("/update")
    public Categoria editarUmaCategoria(@RequestBody Categoria categoria){

        return categoriaService.editarUmaCategoria(categoria);
    }

}
