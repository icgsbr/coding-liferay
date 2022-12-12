package br.com.senac.codingliferay.repositories;

import br.com.senac.codingliferay.models.CollaboratorModel;
import br.com.senac.codingliferay.models.FormModel;
import br.com.senac.codingliferay.models.InstitutionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FormRepository extends JpaRepository<FormModel, Long> {
    @Query(
            value = "select institution " +
            "from InstitutionModel institution " +
            "where institution.name = :name"
    )
    Optional<InstitutionModel> getInstitution(
            @Param(value = "name") String name
    );

    @Query(
            value = "select collaborator " +
                    "from CollaboratorModel collaborator " +
                    "where collaborator.name = :name"
    )
    Optional<CollaboratorModel> getCollaborator(
            @Param(value = "name") String name
    );

    @Query(
            value = "select sum(form.value) " +
                    "from FormModel form"
    )
    Double getAmountDonated();
}
