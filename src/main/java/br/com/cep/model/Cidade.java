package br.com.cep.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@SuperBuilder
@Entity
@Table(name = "TCidade")
@NoArgsConstructor
@AllArgsConstructor
public class Cidade {

  //Definindo os atributos da tabela e suas anotações
  @Id
  @Column(length = 20, nullable = false, unique = true)
  private String ibge;

  @Column(length = 2, nullable = false)
  private String uf;

  @Column(length = 100, nullable = false)
  private String localidade;


  //Getter And Setter
  public String getIbge() {
    return ibge;
  }

  public void setIbge(String ibge) {
    this.ibge = ibge;
  }

  public String getUf() {
    return uf;
  }

  public void setUf(String uf) {
    this.uf = uf;
  }

  public String getLocalidade() {
    return localidade;
  }

  public void setLocalidade(String localidade) {
    this.localidade = localidade;
  }
}
