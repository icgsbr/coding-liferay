package br.com.senac.codingliferay.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "collaborator")
@Data
@NoArgsConstructor
public class CollaboratorModel {
    //region ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String jobRole;
    //endregion

    //region CONSTRUCTORS
    public CollaboratorModel(String name, String jobRole) {
        this.name = name;
        this.jobRole = jobRole;
    }
    //endregion
}
