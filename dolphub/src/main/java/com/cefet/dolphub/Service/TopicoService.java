package com.cefet.dolphub.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cefet.dolphub.Repositorio.*;
import com.cefet.dolphub.Entidades.Main.Curso;
import com.cefet.dolphub.Entidades.Recursos.*;
import java.util.List;
import java.util.Optional;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    
    public TopicoService() {
    }

    public List<Topico> listarTopicosPorCurso(Curso curso) {
        return topicoRepository.findByCurso(curso);
    }

    public Topico salvarTopico(Topico topico) {
        return topicoRepository.save(topico);
    }

    public Topico buscar(Long id) {
        Optional<Topico> topico = topicoRepository.findById(id);
        return topico.orElseThrow(() -> new RuntimeException("Topico não encontrado!"));
    }

    public Topico encontrarTopicoPorId(Long id) {
        return topicoRepository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        topicoRepository.deleteById(id);
    }

    public List<Topico> listarTopicos() {
        return topicoRepository.findAll();
    }

}