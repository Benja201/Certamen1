package com.example.certamen1.entities;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "libros")
public class Libro implements Serializable {

    @Id
    @NotBlank(message = "Falta el título")
    private String titulo;

    @NotBlank(message = "Falta el autor")
    private String autor;

    @NotBlank(message = "Falta el OSBN")
    @Size(min = 13, max = 13, message = "El ISBN debe tener exactamente 13 caracteres")
    private String isbn;

    @Min(value = 11, message = "Las páginas deben ser mayores que 10")
    private int paginas;

    @NotBlank(message = "Falta la categoría")
    private String categoria;
}


