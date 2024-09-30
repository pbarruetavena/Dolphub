package com.cefet.dolphub.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cefet.dolphub.Entidades.Main.Curso;
import com.cefet.dolphub.Service.CursoService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cefet.dolphub.Entidades.Main.Usuario;

@Controller
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @GetMapping("/criarCurso")
    public String enviarMidia(Model model) {
        model.addAttribute("curso", new Curso());
        return "criar_curso";
    }

    @PostMapping("/salvarCurso")
    public String salvarCurso(@ModelAttribute Curso curso, RedirectAttributes redirectAttributes) {
        cursoService.salvarCurso(curso);
        return "teste";
    }
    @GetMapping("/cursos")
    public String exibirPerfil(Model model, @AuthenticationPrincipal Usuario usuarioLogado) {
        model.addAttribute("usuarioLogado", usuarioLogado);
        return "cursos_adquiridos";
    }
}