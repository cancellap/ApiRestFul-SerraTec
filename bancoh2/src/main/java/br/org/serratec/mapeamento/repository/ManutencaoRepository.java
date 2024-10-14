package br.org.serratec.mapeamento.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.serratec.mapeamento.domain.Manutencao;

@Repository
public interface ManutencaoRepository extends JpaRepository<Manutencao, Long> {

}
