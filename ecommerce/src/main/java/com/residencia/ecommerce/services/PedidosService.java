package com.residencia.ecommerce.services;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.ecommerce.entities.Pedidos;
import com.residencia.ecommerce.entities.ProdutosPedidos;
import com.residencia.ecommerce.exceptions.EmailException;
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
    @Autowired 
    public EmailService emailService;



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

    public FecharPedidoVO fecharPedido(Integer id ) throws MessagingException, EmailException{

        Pedidos pedidos = pedidosRepository.findById(id).get();
        FecharPedidoVO fpVO = new FecharPedidoVO();

        if (!pedidos.getStatus().equalsIgnoreCase("fechado")){
           
            fpVO.setPedidoId(id);
            fpVO.setClienteEmail(pedidos.getCliente().getEmail());
            
           
            List<ProdutosPedidos> produtosPedidosList= pedidos.getListProdutoPedido();
            List<ProdutoQtdVO> listProdQtd = new ArrayList<>();
            
            
            for(ProdutosPedidos pp : produtosPedidosList) {
            	ProdutoQtdVO prodQtd = new ProdutoQtdVO();
            	prodQtd.setNomeProduto(pp.getProdutos().getNome());
            	prodQtd.setQuantidade(pp.getQuantidade());
            	listProdQtd.add(prodQtd);
            }
            
            fpVO.setListProdutoQtd(listProdQtd);
            fpVO.setValorCompra(pedidos.getValorPedido());
            
            emailService.emailFecharPedido(fpVO);

            pedidos.setStatus("fechado");
            pedidosRepository.save(pedidos);
            return fpVO;
        }else{
            pedidos.setStatus("testado");
            pedidosRepository.save(pedidos);
        }
        return fpVO;
    }

}