package com.cefet.dolphub.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cefet.dolphub.Entidades.Recursos.*;
import com.cefet.dolphub.Entidades.Main.*;
import com.cefet.dolphub.Service.*;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GerenciarQuestaoController {

    // @Autowired
    // private QuestaoService questaoService;
    @Autowired
    private RecursoService recursoService;
    @Autowired
    private CursoService cursoService;

    @GetMapping("editarCurso/{idCurso}/enviarQuestao/{idPai}")
    public String enviarQuestao(@PathVariable Long idCurso, @PathVariable Long idPai, Model model,
            @AuthenticationPrincipal Usuario usuarioLogado) {
        Questao questao = new Questao();
        Topico topicoPai = recursoService.buscarTopicoPai(idPai);
        Curso curso = cursoService.buscar(idCurso);

        model.addAttribute("arquivo", questao);
        model.addAttribute("topicoPai", topicoPai.getId());
        model.addAttribute("curso", curso);
        model.addAttribute("operation", "enviar");
        model.addAttribute("usuarioLogado", usuarioLogado);

        return "enviar_questao";
    }

}