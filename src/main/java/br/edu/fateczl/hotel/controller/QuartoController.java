package br.edu.fateczl.hotel.controller;

import br.edu.fateczl.hotel.service.QuartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/quarto")
public class QuartoController {

    @Autowired
    private QuartoService quartoService;

    @GetMapping
    public String carregarForm(Model model) {
        model.addAttribute("quarto", new QuartoDTO(null, null, null, null, null));
        model.addAttribute("mensagem", null);
        model.addAttribute("resultadoBusca", null);
        model.addAttribute("listaQuartos", null);
        return "quartos";
    }

    @PostMapping("/criar")
    public String criarQuarto(@ModelAttribute @Valid QuartoDTO quarto, Model model) {
        String mensagem = quartoService.criarQuarto(quarto);
        model.addAttribute("mensagem", mensagem);
        model.addAttribute("quarto", new QuartoDTO(null, null, null, null, null));
        return "quartos";
    }

    @PostMapping("/buscar")
    public String buscarQuartoPorId(@RequestParam Long id, Model model) {
        QuartoDTO quarto = quartoService.buscarQuartoPorId(id);
        model.addAttribute("resultadoBusca", quarto);
        model.addAttribute("quarto", new QuartoDTO(null, null, null, null, null));
        return "quartos";
    }

    @PostMapping("/atualizar")
    public String atualizarQuarto(@ModelAttribute @Valid QuartoDTO quarto, Model model) {
        String mensagem = quartoService.atualizarQuarto(quarto);
        model.addAttribute("mensagem", mensagem);
        return "quartos";
    }

    @PostMapping("/excluir")
    public String excluirQuarto(@RequestParam Long id, Model model) {
        String mensagem = quartoService.excluirQuarto(id);
        model.addAttribute("mensagem", mensagem);
        return "quartos";
    }

    @PostMapping("/listar")
    public String listarQuartos(Model model) {
        List<QuartoDTO> lista = quartoService.listarQuartos();
        model.addAttribute("listaQuartos", lista);
        return "quartos";
    }

}