package br.com.senac.codingliferay.repositories;

import br.com.senac.codingliferay.models.CollaboratorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CollaboratorRepository extends JpaRepository<CollaboratorModel, Long> {
    @Query(value = "select collaborator from CollaboratorModel collaborator where collaborator.name = :name")
    CollaboratorModel findByName(@Param(value = "name") String name);
}
