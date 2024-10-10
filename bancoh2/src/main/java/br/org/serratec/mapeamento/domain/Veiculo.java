package br.org.serratec.mapeamento.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Preencha a placa")
	@Size(max = 7)
	@Column(nullable = false, length = 7)
	private String placa;

	@NotBlank(message = "Preencha a marca")
	@Size(max = 30)
	@Column(nullable = false, length = 30)
	private String marca;

	@NotBlank(message = "Preencha o marca")
	@Size(max = 30)
	@Column(nullable = false, length = 30)
	private String modelo;

	@Embedded
	private Cacteristicas caracteristicas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Cacteristicas getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(Cacteristicas caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	
}
