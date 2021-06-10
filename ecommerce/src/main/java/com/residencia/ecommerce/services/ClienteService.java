package com.residencia.ecommerce.services;




import com.residencia.ecommerce.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.residencia.ecommerce.entities.Cliente;


@Service
public class ClienteService {

    @Autowired
    public ClienteRepository clienteRepository;



    //FAZER PELO VO
    public Cliente atualizarDadosPessoais(Cliente Cliente) {
        return clienteRepository.save(Cliente);
        // cpf nao

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





}

