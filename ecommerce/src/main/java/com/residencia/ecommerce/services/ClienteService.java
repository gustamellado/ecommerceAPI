package com.residencia.ecommerce.services;




import com.residencia.ecommerce.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.residencia.ecommerce.entities.Cliente;


@Service
public class ClienteService {

    @Autowired
    public ClienteRepository clienteRepository;


    public Cliente findById(Integer id) {
    	return clienteRepository.findById(id).get();
    }

    //FAZER PELO VO
    public Cliente atualizarDadosPessoais(Cliente Cliente) {
        
    	Cliente antigoCliente = atualizaCliente(Cliente);
    	return clienteRepository.save(antigoCliente);

    }

    public boolean deletarConta(Integer id){
        if(id != null) {
            clienteRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }


    }

    private Cliente atualizaCliente(Cliente cliente) {
    	Cliente antigoCliente = clienteRepository.getById(cliente.getClientId());
    	
    	antigoCliente.setDataDeNascimento((cliente.getDataDeNascimento()==null)? antigoCliente.getDataDeNascimento():cliente.getDataDeNascimento());
    	antigoCliente.setEmail((cliente.getEmail()==null)?antigoCliente.getEmail():cliente.getEmail());
    	antigoCliente.setEndereco((cliente.getEndereco()==null)?antigoCliente.getEndereco():cliente.getEndereco());
    	antigoCliente.setNome((cliente.getNome()==null)?antigoCliente.getNome():cliente.getNome());
    	antigoCliente.setSenha((cliente.getSenha()==null)?antigoCliente.getSenha():cliente.getSenha());
    	antigoCliente.setTelefone((cliente.getTelefone()==null)?antigoCliente.getTelefone():cliente.getTelefone());
    	antigoCliente.setUsername((cliente.getUsername()==null)?antigoCliente.getUsername():cliente.getUsername());
    	
    	return antigoCliente;
    }

}

