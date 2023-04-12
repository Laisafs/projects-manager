package one.digitalinnovation.projectsmanager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import one.digitalinnovation.projectsmanager.model.Projeto;

@Repository
public interface ProjetoRepository extends CrudRepository<Projeto, Long> {

}
