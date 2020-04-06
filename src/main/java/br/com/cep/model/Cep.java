package br.com.cep.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@SuperBuilder
@Entity
@Table(name="TCep")
@NoArgsConstructor
@AllArgsConstructor
public class Cep {

	//Definindo os atributos da tabela e suas anotações
	@Id
	@Column(length = 10, nullable = false, unique = true)
	private String cep;

	@Column(length = 255, nullable = false)
	private String logradouro;

	@Column(length = 255, nullable = true)
	private String complemento;

	@Column(length = 50, nullable = true)
	private String bairro;

	//Foreign key com a tabela TCidade
	@OneToOne(targetEntity = Cidade.class, cascade= CascadeType.ALL)
	private Cidade cidade;


	//Getter And Setter
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Cidade getIbge() {
		return cidade;
	}

	public void setIbge(Cidade ibge) {
		this.cidade = ibge;
	}
}
