package br.com.alphapires.listavip.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alphapires.listavip.model.Convidado;

@Repository
public interface ConvidadoRepository extends CrudRepository<Convidado, Long>{

}
