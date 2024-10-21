package org.serratec.bakcend.servicedto.repository;

import java.util.List;

import org.serratec.bakcend.servicedto.domain.Funcionario;
import org.serratec.bakcend.servicedto.dto.FuncionarioSalarioDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

//	    Dizendo pro Spring que esse
//	    metodo vai ser uma query JPQL.
	
	// Via Spring
	Page<Funcionario> findBySalarioBetween(Double valorMinimo, Double valorMaximo, Pageable pageable);

	// Via JPQL
	@Query("Select f from Funcionario f where f.salario >= :valorMinimo AND f.salario <=:valorMaximo")
	Page<Funcionario> buscarSalario(Double valorMinimo, Double valorMaximo, Pageable pageable);

	// Via query nativa - SQL Postgres
	@Query(value = "SELECT * FROM Funcionario f WHERE f.salario >= :valorMinimo AND f.salario <= :valorMaximo", nativeQuery = true)
	Page<Funcionario> buscarSalarioNativo(Double valorMinimo, Double valorMaximo, Pageable pageable);

	// Spring
	Page<Funcionario> findByNomeContainingIgnoreCase(String paramNome, Pageable pageable);

	// Upper passa tudo do nome do meu funcionário para maiúsculo //
	@Query("SELECT f from Funcionario f WHERE UPPER(f.nome) LIKE UPPER (CONCAT('%', :paramNome, '%')) ")
	Page<Funcionario> buscarPorNome(String paramNome, Pageable pageable);

	// Com o value e o native query é uma query SQL Postgres, não JPQL
//	    age calcula o now com o campo de nascimento e passa pro year o resultado.

	@Query(value = """
			    SELECT
			        date_part('year', age(now(), data_nascimento)) as idade,
			        avg(salario) as mediaSalario,
			        min(salario) as menorSalario,
			        max(salario) as maiorSalario,
			        count(*) as totalFuncionarios
			    FROM funcionario
			    GROUP BY idade
			    HAVING count(*) > 1
			    ORDER BY idade desc
			""", nativeQuery = true)
	List<FuncionarioSalarioDTO> buscarSalariosPorIdade();

}
