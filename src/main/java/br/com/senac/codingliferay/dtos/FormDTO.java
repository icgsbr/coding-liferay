package br.com.senac.codingliferay.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormDTO {
    @NotBlank
    private String nameInstitution;

    @NotBlank
    private String emailInstitution;

    @NotBlank
    private Long phoneNumberInstitution;

    @NotBlank
    private String cityInstitution;

    @NotBlank
    private String stateInstitution;

    @NotBlank
    private String countryInstitution;

    @NotBlank
    private Double value;
}
