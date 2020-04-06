package br.com.cep.repository;

import br.com.cep.model.Cep;
import br.com.cep.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, String> {

    @Query("SELECT cidade FROM Cidade cidade WHERE cidade.ibge = :ibge")
    List<Cidade> findByCidade(@Param(value = "ibge") String ibge);
}