package br.org.serratec.mapeamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.serratec.mapeamento.domain.Servico;

@Repository
public interface SerivicoRepository extends JpaRepository<Servico, Long>{

}
