package org.serratec.bakcend.servicedto.repository;

import org.serratec.bakcend.servicedto.domain.UsuarioPerfilPK;
import org.serratec.bakcend.servicedto.domain.UsuarioPerfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioPeriflRepository extends JpaRepository<UsuarioPerfil, UsuarioPerfilPK> {

}
