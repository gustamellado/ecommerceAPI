package com.residencia.ecommerce.services;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.residencia.ecommerce.entities.Cliente;
import com.residencia.ecommerce.repositories.ClienteRepository;
import com.residencia.ecommerce.vo.CadastroClienteVO;

import java.util.List;


@Service
public class ClienteService {

    @Autowired
    public ClienteRepository clienteRepository;

    public Cliente criarUmaNovaConta(CadastroClienteVO cadastro){
    	Cliente cliente = new Cliente();
    	cliente = converteCadastroVOParaEntidade(cadastro); 
    	clienteRepository.save(cliente);
        return  cliente;
    }


    private Cliente converteCadastroVOParaEntidade(CadastroClienteVO cadastro) {
		Cliente cliente = new Cliente();
		
		cliente.setCpf(cadastro.getCpf());
		cliente.setDataDeNascimento(cadastro.getDataNascimento());
		cliente.setEmail(cadastro.getEmail());
		cliente.setEndereco(cadastro.getEndereco());
		cliente.setNome(cadastro.getNome());
		cliente.setSenha(new BCryptPasswordEncoder().encode(cadastro.getSenha()));
		cliente.setTelefone(cadastro.getTelefone());
		cliente.setUsername(cadastro.getUsername());
		return cliente;
	}


	public Cliente findById(Integer id) {
    	return clienteRepository.findById(id).get();
    }

    public List<Cliente> findAll(){
    	return clienteRepository.findAll();
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

    public Cliente atualizarDadosPessoais(Cliente Cliente) {

    	Cliente antigoCliente = atualizaCliente(Cliente);
    	return clienteRepository.save(antigoCliente);

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

