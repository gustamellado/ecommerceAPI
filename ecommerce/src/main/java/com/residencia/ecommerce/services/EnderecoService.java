package com.residencia.ecommerce.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.residencia.ecommerce.entities.Endereco;
import com.residencia.ecommerce.repositories.EnderecoRepository;
import com.residencia.ecommerce.vo.EnderecoClienteVO;

@Service
public class EnderecoService {
	
	@Autowired EnderecoRepository enderecoRepository;
	
	public EnderecoClienteVO consultarDadosPorCep(String cep) {
		
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://viacep.com.br/ws/{cep}/json/";
		
		Map<String,String> params = new HashMap<String,String>();
		params.put("cep", cep);
		
		EnderecoClienteVO enderecoVO = restTemplate.getForObject(url, EnderecoClienteVO.class , params);
		
		return enderecoVO;
	}
	
	public Endereco saveVO(EnderecoClienteVO enderecoVO,String numero,String complemento) {
		Endereco endereco = new Endereco();
		endereco = converteVOParaEntidade(enderecoVO);
		endereco.setComplemento(complemento);
		endereco.setNumero(numero);
		enderecoRepository.save(endereco);
		return endereco;
	}
	
	private Endereco converteVOParaEntidade(EnderecoClienteVO cep) {
		Endereco endereco = new Endereco();
		
		endereco.setBairro(cep.getBairro());
		endereco.setCep(cep.getCep());
		endereco.setCidade(cep.getLocalidade());
		endereco.setEstado(cep.getUf());
		endereco.setRua(cep.getLogradouro());
		return endereco;
	}
	
	private EnderecoClienteVO converteEntidadeParaVO(Endereco endereco) {
		EnderecoClienteVO cep = new EnderecoClienteVO();
		
		cep.setBairro(endereco.getBairro());
		cep.setCep(endereco.getCep());
		cep.setLocalidade(endereco.getCidade());
		cep.setLogradouro(endereco.getRua());
		cep.setUf(endereco.getEstado());
		
		return cep;
	}
}
