package estudos.spring.repository;

import estudos.spring.model.Cliente;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

    @Query("SELECT c FROM Cliente c WHERE UPPER(c.endereco.uf) = UPPER(:uf)")
    Iterable<Cliente> findAllByEndereco_UfIgnoreCase(@Param("uf") String uf);
}
