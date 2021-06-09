package com.residencia.ecommerce.services;

import java.util.List;

import com.residencia.ecommerce.entities.Categoria;
import com.residencia.ecommerce.repositories.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.ecommerce.entities.Pedidos;


@Service
public class PedidosService {

    @Autowired
    public PedidosRepository pedidosRepository;


    public Pedidos vizualizarUmPedido(Integer pedidoid){
        return pedidosRepository.findById(pedidoid).get();
    }

    public List<Pedidos> vizualizarTodosOsPedidos(){
        return pedidosRepository.findAll();
    }

    public Long quantidadeDePedidos() {
        return pedidosRepository.count();
    }

    public Pedidos criarUmNovoPedido(Pedidos pedidos){
        Pedidos novoPedido = pedidosRepository.save(pedidos);
        return  novoPedido;
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

    public Pedidos editarUmPedido(Pedidos pedidos) {
        return pedidosRepository.save(pedidos);
    }

    //public Pedidos editarUmPedidoParaFinalizado(Pedidos pedidos);
    //public Pedidos FinalizarPedido(Pedidos pedidos);

}