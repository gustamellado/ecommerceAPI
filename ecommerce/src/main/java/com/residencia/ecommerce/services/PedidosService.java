package com.residencia.ecommerce.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.ecommerce.entities.Pedidos;
import com.residencia.ecommerce.entities.ProdutosPedidos;
import com.residencia.ecommerce.repositories.PedidosRepository;
import com.residencia.ecommerce.repositories.ProdutosPedidosRepository;
import com.residencia.ecommerce.vo.FecharPedidoVO;
import com.residencia.ecommerce.vo.ProdutoQtdVO;


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
            FecharPedidoVO fpVO = new FecharPedidoVO();
            fpVO.setPedidoId(id);
            fpVO.setClienteEmail(pedidos.getCliente().getEmail());
            
            float total = 0;
            
            List<ProdutosPedidos> produtosPedidosList= produtosPedidosRepository.FindByPedido(pedidos);
            List<ProdutoQtdVO> listProdQtd = new ArrayList<>();
            ProdutoQtdVO prodQtd = new ProdutoQtdVO();
            
            for(ProdutosPedidos pp : produtosPedidosList) {
            	total= pp.getPreco()*pp.getQuantidade();
            	prodQtd.setNomeProduto(pp.getProdutos().getNome());
            	prodQtd.setQuantidade(pp.getQuantidade());
            	listProdQtd.add(prodQtd);
            }
            
            fpVO.setListProdutoQtd(listProdQtd);
           fpVO.setValorCompra(total);

            pedidos.setStatus("fechado");
            pedidosRepository.save(pedidos);
        }else{
            pedidos.setStatus("testado");
            pedidosRepository.save(pedidos);
        }
        return pedidos;
    }

}