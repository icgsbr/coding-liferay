package br.com.senac.codingliferay.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditFormDTO {
    @NotBlank
    private String nameInstitution;

    @NotBlank
    private Double value;
}
