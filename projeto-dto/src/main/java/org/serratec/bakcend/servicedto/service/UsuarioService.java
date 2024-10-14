package org.serratec.bakcend.servicedto.service;

import java.util.List;
import java.util.Optional;

import org.serratec.bakcend.servicedto.domain.Usuario;
import org.serratec.bakcend.servicedto.exception.EmailException;
import org.serratec.bakcend.servicedto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository ur;

	public List<Usuario> findAll(){
		return ur.findAll();
	}
	
	public Optional<Usuario> buscar(Long id) {
		return ur.findById(id);
	}
	
	public Usuario inserir(Usuario user) throws EmailException {
		Usuario usuario = ur.findByEmail(user.getEmail());
		
		if (usuario != null) {
			throw new EmailException("Email ja existente");
		}
		return ur.save(user);
	}
}
