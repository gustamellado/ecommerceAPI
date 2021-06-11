package com.residencia.ecommerce.controllers;

import com.residencia.ecommerce.entities.Pedidos;
import com.residencia.ecommerce.services.PedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/fecharPedido/{id}")
    public Pedidos fecharPedido(@PathVariable Integer id){

        return pedidosService.fecharPedido(id);


    }


}
