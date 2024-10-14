package org.serratec.bakcend.servicedto.repository;

import org.serratec.bakcend.servicedto.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Usuario findByEmail(String x);
}
