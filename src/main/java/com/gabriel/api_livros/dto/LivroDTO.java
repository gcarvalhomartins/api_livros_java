package com.gabriel.api_livros.dto;

import lombok.Data;

@Data
public class LivroDTO {
    private Long id;
    private String titulo;
    private String autor;
    private String isbn;
    private int anoPublicacao;
}