package br.com.senac.codingliferay.repositories;

import br.com.senac.codingliferay.models.InstitutionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitutionRepository extends JpaRepository<InstitutionModel, Long> {
    @Query(value = "select institution from InstitutionModel institution where institution.name = :name")
    InstitutionModel findByName(@Param(value = "name") String name);
}
