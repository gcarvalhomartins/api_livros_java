package com.gabriel.api_livros.livros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gabriel.api_livros.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
}