package br.edu.fateczl.hotel.controller;

import br.edu.fateczl.hotel.dto.EstadiaDTO;
import br.edu.fateczl.hotel.service.EstadiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/estadia")
public class EstadiaController {

    @Autowired
    private EstadiaService estadiaService;

    @GetMapping
    public String carregarForm(Model model) {

        model.addAttribute("estadia", new EstadiaDTO(null, null, null, null, null, null));
        model.addAttribute("mensagem", null);
        model.addAttribute("resultadoBusca", null);
        model.addAttribute("listaEstadia", null);

        return "estadia";

    }

    @PostMapping("/criar")
    public String criarEstadia(@ModelAttribute EstadiaDTO estadia, Model model) {

        String mensagem = estadiaService.criarEstadia(estadia);

        model.addAttribute("mensagem", mensagem);
        model.addAttribute("estadia", new EstadiaDTO(null, null, null, null, null, null));

        return "estadia";

    }

    @PostMapping("/buscar")
    public String buscarEstadiaPorId(@RequestParam Long id, Model model) {

        EstadiaDTO estadia = estadiaService.buscarEstadiaPorId(id);

        model.addAttribute("resultadoBusca", estadia);
        model.addAttribute("estadia", new EstadiaDTO(null, null, null, null, null, null));

        return "estadia";

    }

    @PostMapping("/atualizar")
    public String atualizarEstadia(@ModelAttribute EstadiaDTO estadia, Model model) {

        String mensagem = estadiaService.atualizarEstadia(estadia);

        model.addAttribute("mensagem", mensagem);

        return "estadia";

    }

    @PostMapping("/excluir")
    public String excluirEstadia(@RequestParam Long id, Model model) {

        String mensagem = estadiaService.excluirEstadia(id);

        model.addAttribute("mensagem", mensagem);

        return "estadia";
    }

    @PostMapping("/listar")
    public String listarEstadias(Model model) {

        List<EstadiaDTO> lista = estadiaService.listarEstadia();

        model.addAttribute("listaEstadia", lista);

        return "estadia";

    }

}