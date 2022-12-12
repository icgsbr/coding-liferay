package br.com.senac.codingliferay.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.Column;

@Entity
@Table(name = "form")
@Data
@NoArgsConstructor
public class FormModel {
    //region ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private CollaboratorModel collaborator;

    @ManyToOne
    private InstitutionModel institution;

    @Column(nullable = false)
    private Double value;
    //endregion

    //region CONSTRUCTORS
    public FormModel(CollaboratorModel collaborator, InstitutionModel institution, Double value) {
        this.collaborator = collaborator;
        this.institution = institution;
        this.value = value;
    }
    //endregion
}
