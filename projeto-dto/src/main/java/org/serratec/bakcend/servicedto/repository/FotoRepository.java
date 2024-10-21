package org.serratec.bakcend.servicedto.repository;

import java.util.Optional;

import org.serratec.bakcend.servicedto.domain.Foto;
import org.serratec.bakcend.servicedto.domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FotoRepository extends JpaRepository<Foto, Long> {

	Optional<Foto> findByFuncionario (Funcionario funcionario);
}
