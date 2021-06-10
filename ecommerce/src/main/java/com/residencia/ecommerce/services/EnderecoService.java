package com.residencia.ecommerce.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.residencia.ecommerce.repositories.EnderecoRepository;
import com.residencia.ecommerce.vo.CepVO;

@Service
public class EnderecoService {
	
	@Autowired EnderecoRepository enderecoRepository;
	
	public CepVO consultarDadosPorCep(String cep) {
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://www.viacep.com.br/ws/{cep}/json/";
		
		Map<String,String> params = new HashMap<String,String>();
		params.put("cep", cep);
		
		CepVO cepVO = restTemplate.getForObject(url, CepVO.class , params);;
		
		return cepVO;
	}
}
