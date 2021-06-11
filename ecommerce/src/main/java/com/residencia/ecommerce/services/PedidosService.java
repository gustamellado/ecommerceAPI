package com.residencia.ecommerce.services;

import java.util.List;

import com.residencia.ecommerce.entities.Categoria;
import com.residencia.ecommerce.entities.Cliente;
import com.residencia.ecommerce.entities.ProdutosPedidos;
import com.residencia.ecommerce.repositories.ClienteRepository;
import com.residencia.ecommerce.repositories.PedidosRepository;
import com.residencia.ecommerce.repositories.ProdutosPedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.ecommerce.entities.Pedidos;


@Service
public class PedidosService {

    @Autowired
    public PedidosRepository pedidosRepository;
    @Autowired
    public ProdutosPedidosRepository produtosPedidosRepository;



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

    public Pedidos fecharPedido(Integer id ){

        Pedidos pedidos = pedidosRepository.findById(id).get();


        if (!pedidos.getStatus().equalsIgnoreCase("fechado")){
            String email = pedidos.getCliente().getEmail();
            List<ProdutosPedidos> produtosPedidosList= produtosPedidosRepository.FindByPedido(pedidos);

            pedidos.setStatus("fechado");
            pedidosRepository.save(pedidos);
        }else{
            pedidos.setStatus("testado");
            pedidosRepository.save(pedidos);
        }
        return pedidos;
    }

}