package br.com.senac.codingliferay.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "institution")
@Data
@NoArgsConstructor
public class InstitutionModel {
    //region ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private Long phoneNumber;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private LocalDateTime dateOfCreation = LocalDateTime.now();
    //endregion

    //region CONSTRUCTORS
    public InstitutionModel(String name, String email, Long phoneNumber, String city, String state) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.state = state;
        this.dateOfCreation = LocalDateTime.now();
    }
    //endregion
}
