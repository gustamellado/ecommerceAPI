package com.residencia.ecommerce.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.residencia.ecommerce.entities.Cliente;
import com.residencia.ecommerce.services.ClienteService;
import com.residencia.ecommerce.services.EnderecoService;
import com.residencia.ecommerce.vo.CadastroClienteVO;

@RestController
@RequestMapping("/Cliente")
public class ClienteController {


    @Autowired
    ClienteService clienteService;
    @Autowired
    EnderecoService enderecoService;

    @PostMapping("/save")
    public Cliente criarUmaNovaConta(@Valid @RequestBody CadastroClienteVO cadastro) {
    	
    	cadastro.setEndereco(enderecoService.saveVO(enderecoService.consultarDadosPorCep(cadastro.getCep()),cadastro.getNumero(),cadastro.getComplemento()));
    	
    	return clienteService.criarUmaNovaConta(cadastro);
    	/*HttpHeaders headers = new HttpHeaders();

        if(null != clienteService.criarUmaNovaConta(cadastro))
            return new ResponseEntity<>(clienteService.criarUmaNovaConta(cadastro), headers, HttpStatus.OK);
        else
            return new ResponseEntity<>(clienteService.criarUmaNovaConta(cadastro), headers, HttpStatus.BAD_REQUEST);*/
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
    public ResponseEntity<Cliente> atualizarConta(@Valid @RequestBody Cliente cliente){
    	 HttpHeaders headers = new HttpHeaders();
    	return new ResponseEntity<>(clienteService.atualizarDadosPessoais(cliente),headers,HttpStatus.OK);
    }
    




}
