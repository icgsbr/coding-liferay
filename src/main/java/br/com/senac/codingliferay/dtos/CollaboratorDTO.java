package br.com.senac.codingliferay.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollaboratorDTO {
    @NotBlank
    private String name;

    @NotBlank
    private String jobRole;
}
