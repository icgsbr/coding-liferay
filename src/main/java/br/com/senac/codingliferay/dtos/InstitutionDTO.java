package br.com.senac.codingliferay.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstitutionDTO {
    @NotBlank
    private String name;

    @NotBlank
    private String email;

    @NotBlank
    private Long phoneNumber;

    @NotBlank
    private String city;

    @NotBlank
    private String state;

    @NotBlank
    private String country;
}
