package org.serratec.bakcend.servicedto.service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.serratec.bakcend.servicedto.domain.Perfil;
import org.serratec.bakcend.servicedto.domain.Usuario;
import org.serratec.bakcend.servicedto.domain.UsuarioPerfil;
import org.serratec.bakcend.servicedto.dto.UsuarioDTO;
import org.serratec.bakcend.servicedto.dto.UsuarioInserirDTO;
import org.serratec.bakcend.servicedto.exception.EmailException;
import org.serratec.bakcend.servicedto.exception.SenhaException;
import org.serratec.bakcend.servicedto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PerfilService perfilService;

	public List<UsuarioDTO> findAll() {
		List<Usuario> usuarios = usuarioRepository.findAll();
//		List<UsuarioDTO> usuariosDto = new ArrayList<UsuarioDTO>();
//		for (Usuario usuario : usuarios) {
//			usuariosDto.add(new UsuarioDTO(usuario));
//		}
//		
		// retorna lista de usuariosDTO
		return usuarios.stream().map(UsuarioDTO::new).toList();
	}

	public Optional<Usuario> buscar(Long id) {
		return usuarioRepository.findById(id);
	}

	@Transactional
	public UsuarioDTO inserir(UsuarioInserirDTO usuarioInserirDTO) throws EmailException, SenhaException {
		if (!usuarioInserirDTO.getSenha().equals(usuarioInserirDTO.getConfirmarSenha())) {
			throw new SenhaException("Senha e Confirma Senha não são iguais");
		}
		if (usuarioRepository.findByEmail(usuarioInserirDTO.getEmail()) != null) {
			throw new EmailException("Email já existente");
		}

		Usuario usuario = new Usuario();
		usuario.setNome(usuarioInserirDTO.getNome());
		usuario.setEmail(usuarioInserirDTO.getEmail());
		usuario.setSenha(usuarioInserirDTO.getSenha());

		Set<UsuarioPerfil> perfis = new HashSet<>();
		for (Perfil perfil : usuarioInserirDTO.getPerfis()) {
			perfil = perfilService.buscar(perfil.getId());
			UsuarioPerfil usuarioPerfil = new UsuarioPerfil(usuario, perfil, LocalDate.now());
			perfis.add(usuarioPerfil);
		}
		usuario.setUsuarioPerfis(perfis);

		usuario = usuarioRepository.save(usuario);

		UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);
		return usuarioDTO;
	}
}
