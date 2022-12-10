package br.com.senac.codingliferay.repositories;

import br.com.senac.codingliferay.models.FormModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormRepository extends JpaRepository<FormModel, Long> {

}
