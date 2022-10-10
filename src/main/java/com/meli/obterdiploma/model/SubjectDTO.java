package com.meli.obterdiploma.model;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Data
public class SubjectDTO {
    @NotBlank(message = "O nome do assunto não pode ficar vazio")
    @Pattern(regexp = "\\b[A-Z]\\w*\\b", message = "O nome da matéria deve começar com a letra maiúscula")
    @Size(max=30, message="Comprimento máximo deve ser de 30 caracteres")
    private String name;

    @DecimalMax(value = "10.0", message = "O valor máximo da nota é 10.0")
    @DecimalMin(value = "0.0", message = "O valor mínimo da nota é 0.0")
    @NotNull(message = "A nota não pode estar vazia")
    private Double score;
}
