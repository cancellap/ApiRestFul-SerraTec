package org.serratec.bakcend.servicedto.controller;

import org.serratec.bakcend.servicedto.dto.EnderecoDTO;
import org.serratec.bakcend.servicedto.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;
	
	@GetMapping("/{cep}")
	public ResponseEntity<EnderecoDTO> buscar(@PathVariable String cep) {
		EnderecoDTO enderecoDTO = enderecoService.buscar(cep);
		if (null == enderecoDTO) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(enderecoDTO);
		}
	}
	
}
