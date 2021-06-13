package com.residencia.ecommerce.controllers;

import java.util.List;

import javax.mail.MessagingException;
import javax.validation.Valid;

import com.residencia.ecommerce.entities.Cliente;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.residencia.ecommerce.entities.Pedidos;
import com.residencia.ecommerce.exceptions.EmailException;
import com.residencia.ecommerce.services.PedidosService;
import com.residencia.ecommerce.vo.FecharPedidoVO;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    PedidosService pedidosService;

    @GetMapping("/vizualizar-pedidos")
    public ResponseEntity<List<Pedidos>> vizualizarTodosOsPedidos() throws Exception{

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(pedidosService.vizualizarTodosOsPedidos(),headers, HttpStatus.OK);
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
    public ResponseEntity<Pedidos> excluirUmPedido(@PathVariable Integer id){
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
    public Pedidos editarUmPedido(@Valid @RequestBody Pedidos pedidos){

        return pedidosService.editarUmPedido(pedidos);
    }

    @PutMapping("/fecharPedido/{id}")
    public FecharPedidoVO fecharPedido(@PathVariable Integer id) throws MessagingException, EmailException{

        return pedidosService.fecharPedido(id);


    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedidos> vizualizarUmPedido(@PathVariable Integer id){
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(pedidosService.vizualizarUmPedido(id),headers,HttpStatus.OK);
    }


}
