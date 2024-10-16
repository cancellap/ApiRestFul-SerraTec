package org.serratec.bakcend.servicedto.repository;

import org.serratec.bakcend.servicedto.domain.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long>{

}
