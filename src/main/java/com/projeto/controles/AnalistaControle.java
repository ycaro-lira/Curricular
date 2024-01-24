package com.projeto.controles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.entidades.Analista;
import com.projeto.servicos.AnalistaService;
import com.projeto.utils.SenhaUtils;

@Controller
@RequestMapping("/analistas")
public class AnalistaControle {

    @Autowired
    private AnalistaService analistaService;

    @GetMapping
    public ModelAndView listarAnalistas() {
        ModelAndView modelAndView = new ModelAndView("analista/home");
        modelAndView.addObject("analistas", analistaService.listarTodosAnalistas());
        return modelAndView;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrarAnalista() {
        ModelAndView modelAndView = new ModelAndView("analista/cadastro-analista");
        modelAndView.addObject("analista", new Analista());
        return modelAndView;
    }

    @PostMapping("/cadastrar")
    public String cadastrar(Analista analista) {
    
    String senhaEncriptada = SenhaUtils.encode(analista.getSenha());   

         analista.setSenha(senhaEncriptada);
         analistaService.salvarAnalista(analista);
         
       
    return "redirect:/home.html";
 }

    @GetMapping("/editar/{id}")
    public ModelAndView editarAnalista(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("analista/editar-analista");
        Analista analista = analistaService.obterAnalistaPorId(id);
        modelAndView.addObject("analista", analista);
        return modelAndView;
    }

    @PostMapping("/editar/{id}")
    public String atualizarAnalista(@PathVariable Long id, Analista analistaAtualizado) {
        Analista analistaExistente = analistaService.obterAnalistaPorId(id);

        if (analistaExistente != null) {
            // Atualizar os campos relevantes
            analistaExistente.setNome(analistaAtualizado.getNome());
            analistaExistente.setEmail(analistaAtualizado.getEmail());
            analistaExistente.setSenha(analistaAtualizado.getSenha());
            analistaExistente.setEmpresa(analistaAtualizado.getEmpresa());

            analistaService.salvarAnalista(analistaExistente);
        }
        return "redirect:/analistas";
    }

    @GetMapping("/deletar/{id}")
    public String deletarAnalista(@PathVariable Long id) {
        analistaService.excluirAnalista(id);
        return "redirect:/analistas";
    }
}
