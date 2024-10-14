package br.org.serratec.mapeamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.serratec.mapeamento.domain.Proprietario;

@Repository
public interface ProprietarioRepository extends JpaRepository<Proprietario, Long> {

}
