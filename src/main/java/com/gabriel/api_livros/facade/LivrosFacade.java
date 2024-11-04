package com.gabriel.api_livros.facade;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabriel.api_livros.dto.LivroDTO;
import com.gabriel.api_livros.model.Livro;
import com.gabriel.api_livros.livros.repository.LivroRepository;

@Service
public class LivrosFacade {

    @Autowired
    private LivroRepository livroRepository;

    public LivroDTO criar(LivroDTO livroDTO) {
        Livro livro = new Livro();
        livro.setTitulo(livroDTO.getTitulo());
        livro.setAutor(livroDTO.getAutor());
        livro.setIsbn(livroDTO.getIsbn());
        livro.setAnoPublicacao(livroDTO.getAnoPublicacao());
        livro = livroRepository.save(livro);
        livroDTO.setId(livro.getId());
        return livroDTO;
    }

    public LivroDTO atualizar(LivroDTO livroDTO, long livroId) {
        Livro livro = livroRepository.findById(livroId).orElseThrow(() -> new RuntimeException("Livro não encontrado"));
        livro.setTitulo(livroDTO.getTitulo());
        livro.setAutor(livroDTO.getAutor());
        livro.setIsbn(livroDTO.getIsbn());
        livro.setAnoPublicacao(livroDTO.getAnoPublicacao());
        livro = livroRepository.save(livro);
        return livroDTO;
    }

    public LivroDTO getById(long livroId) {
        Livro livro = livroRepository.findById(livroId).orElseThrow(() -> new RuntimeException("Livro não encontrado"));
        LivroDTO livroDTO = new LivroDTO();
        livroDTO.setId(livro.getId());
        livroDTO.setTitulo(livro.getTitulo());
        livroDTO.setAutor(livro.getAutor());
        livroDTO.setIsbn(livro.getIsbn());
        livroDTO.setAnoPublicacao(livro.getAnoPublicacao());
        return livroDTO;
    }

    public List<LivroDTO> getAll() {
        return livroRepository.findAll().stream().map(livro -> {
            LivroDTO livroDTO = new LivroDTO();
            livroDTO.setId(livro.getId());
            livroDTO.setTitulo(livro.getTitulo());
            livroDTO.setAutor(livro.getAutor());
            livroDTO.setIsbn(livro.getIsbn());
            livroDTO.setAnoPublicacao(livro.getAnoPublicacao());
            return livroDTO;
        }).collect(Collectors.toList());
    }

    public void deletar(Long livroId) {
        livroRepository.deleteById(livroId);
    }
}