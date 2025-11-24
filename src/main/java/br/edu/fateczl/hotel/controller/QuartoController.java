package br.edu.fateczl.hotel.controller;

import br.edu.fateczl.hotel.dto.QuartoDTO;
import br.edu.fateczl.hotel.dto.QuartoDisponivelDTO;
import br.edu.fateczl.hotel.service.QuartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    public String criarQuarto(@ModelAttribute QuartoDTO quarto, Model model) {

        String mensagem = quartoService.criarQuarto(quarto);

        model.addAttribute("mensagem", mensagem);
        model.addAttribute("quarto", new QuartoDTO(null, null, null, null, null));

        return "quartos";

    }

    @PostMapping("/buscar")
    public String buscarQuartoPorNumero(@RequestParam Integer numero, Model model) {

        QuartoDTO quarto = quartoService.buscarQuartoPorNumero(numero);

        model.addAttribute("resultadoBusca", quarto);
        model.addAttribute("quarto", new QuartoDTO(null, null, null, null, null));

        return "quartos";

    }

    @PostMapping("/atualizar")
    public String atualizarQuarto(@ModelAttribute QuartoDTO quarto, Model model) {

        String mensagem = quartoService.atualizarQuarto(quarto);

        model.addAttribute("mensagem", mensagem);

        return "quartos";

    }

    @PostMapping("/excluir")
    public String excluirQuartoPorNumero(@RequestParam Integer numero, Model model) {

        String mensagem = quartoService.excluirQuartoPorNumero(numero);

        model.addAttribute("mensagem", mensagem);

        return "quartos";

    }

    @PostMapping("/listar")
    public String listarQuartos(Model model) {

        List<QuartoDTO> lista = quartoService.listarQuartos();

        model.addAttribute("listaQuartos", lista);

        return "quartos";

    }

    @GetMapping("/disponiveis")
    public String listarTodosQuartosDisponiveis(Model model){

        return "QuartosDisponiveis";

    }

    @PostMapping("/quartos-disponiveis")
    public String listarQuartosDisponiveis(@RequestParam String data, Model model) {

        LocalDate d = LocalDate.parse(data);

        List<QuartoDisponivelDTO> lista = quartoService.listarQuartosDisponiveis(d);

        model.addAttribute("listaQuartos", lista);

        return "QuartosDisponiveis";
    }
}