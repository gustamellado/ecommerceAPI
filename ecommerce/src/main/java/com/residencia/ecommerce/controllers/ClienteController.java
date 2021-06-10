package com.residencia.ecommerce.controllers;


import com.residencia.ecommerce.entities.Categoria;
import com.residencia.ecommerce.entities.Cliente;
import com.residencia.ecommerce.services.ClienteService;
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
    ClienteService clienteService;

    @PostMapping("/save")
    public ResponseEntity<Cliente> criarUmaNovaConta(@RequestBody Cliente cliente){
        HttpHeaders headers = new HttpHeaders();

        if(null != clienteService.criarUmaNovaConta(cliente))
            return new ResponseEntity<Cliente>(clienteService.criarUmaNovaConta(cliente), headers, HttpStatus.OK);
        else
            return new ResponseEntity<Cliente>(clienteService.criarUmaNovaConta(cliente), headers, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete-conta/{id}")
    public ResponseEntity<Cliente> deletarConta(@PathVariable Integer id){
        HttpHeaders headers = new HttpHeaders();
        boolean isRemoved = clienteService.deletarConta(id);
        if (isRemoved){
            return new ResponseEntity<>(headers,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(headers,HttpStatus.BAD_REQUEST);

        }

    }
    
    @GetMapping("/retornaconta/{id}")
    	 public ResponseEntity<Cliente> findById(@PathVariable Integer id){
        	 HttpHeaders headers = new HttpHeaders();
        	return new ResponseEntity<>(clienteService.findById(id),headers,HttpStatus.OK);
        }
    
    @PutMapping("/atualizaconta")
    public ResponseEntity<Cliente> atualizarConta(@RequestBody Cliente cliente){
    	 HttpHeaders headers = new HttpHeaders();
    	return new ResponseEntity<>(clienteService.atualizarDadosPessoais(cliente),headers,HttpStatus.OK);
    }
    




}
