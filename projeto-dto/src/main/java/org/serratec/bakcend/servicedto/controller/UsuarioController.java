package org.serratec.bakcend.servicedto.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.serratec.bakcend.servicedto.domain.Usuario;
import org.serratec.bakcend.servicedto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
  
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	UsuarioService us;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> listar (){
		return ResponseEntity.ok(us.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> buscar(@PathVariable Long id){
		Optional<Usuario> usuarioOpt = us.buscar(id);
		if (usuarioOpt.isPresent()) {
			return ResponseEntity.ok(usuarioOpt.get());			
		}
		return ResponseEntity.notFound().build();
		
	}
	
	@PostMapping
	public ResponseEntity<Usuario>inserir(@RequestBody Usuario usuario){
		usuario = us.inserir(usuario);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(usuario.getId())
				.toUri();
		return ResponseEntity.created(uri).body(usuario);
	}
}
