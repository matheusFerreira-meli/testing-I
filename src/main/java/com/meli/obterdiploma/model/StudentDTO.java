package com.meli.obterdiploma.model;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Data
public class StudentDTO {
    @NotBlank(message = "O nome do aluno não pode ficar vazio")
    @Pattern(regexp = "\\b[A-Z]\\w*\\b", message = "O nome do aluno deve começar com a letra maiúscula")
    @Size(max=50, message="Comprimento máximo deve ser de 50 caracteres")
    private String studentName;

    private Double averageScore;

    private String message;

    @NotEmpty(message = "A lista de matérias não pode ser vazia")
    private List<@Valid SubjectDTO> subjects;
    // null = void
    // empty = variable = ''
}
