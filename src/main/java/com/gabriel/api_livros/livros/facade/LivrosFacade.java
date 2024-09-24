package com.gabriel.api_livros.livros.facade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.gabriel.api_livros.livros.dto.LivroDTO;


@Service
public class LivrosFacade {
    private static final Map<Long,LivroDTO> livros = new HashMap<>();


    public LivroDTO criar(LivroDTO livroDTO){
            Long proximoId = livroDTO.keySet().size() + 1L;
            livroDTO.setId(proximoId);
            livros.put(proximoId, livroDTO);
            return livroDTO;
    };

    public LivroDTO atualizar(LivroDTO tarefaDTO, long tarefaId){
        livros.put(tarefaId, tarefaDTO);
        return tarefaDTO;

    };
    public LivroDTO getbyId(long tarefaId){
        return livros.get(tarefaId);

    };
    public List<LivroDTO> getAll(){
        return new ArrayList<>(livros.values());
    };
    public String delete(Long tarefaId){
        livros.remove(tarefaId);
        return "Deletado  ";
    };

};