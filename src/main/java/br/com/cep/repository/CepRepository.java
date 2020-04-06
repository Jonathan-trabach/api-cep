package br.com.cep.repository;

import br.com.cep.model.Cep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CepRepository extends JpaRepository<Cep, String> {

    //Metodos para fazer a busca no banco de dados no tipo 'JPQL'
    @Query("SELECT cep FROM Cep cep" +
            " WHERE cep.cidade.ibge = :ibge")
    List<Cep> findByIbge(@Param(value = "ibge") String ibge);

    @Query("SELECT cep FROM Cep cep" +
            " WHERE cep.cidade.ibge = :ibge AND cep.cidade.uf = :uf")
    List<Cep> findByUfAndIbge(@Param(value = "ibge") String ibge, @Param(value = "uf") String uf );

}
