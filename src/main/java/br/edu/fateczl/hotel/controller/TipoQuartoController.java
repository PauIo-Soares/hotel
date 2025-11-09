package br.edu.fateczl.hotel.controller;

import br.edu.fateczl.hotel.dto.TipoQuartoDTO;
import br.edu.fateczl.hotel.service.TipoQuartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tipoQuarto")
public class TipoQuartoController {

    @Autowired
    private TipoQuartoService tipoQuartoService;

    @GetMapping
    public String carregarForm(Model model) {

        model.addAttribute("tipoQuarto", new TipoQuartoDTO(null, null, null));
        model.addAttribute("mensagem", null);
        model.addAttribute("resultadoBusca", null);
        model.addAttribute("listaTipoQuartos", null);

        return "tipoQuartos";

    }

    @PostMapping("/criar")
    public String criarTipoQuarto(@ModelAttribute TipoQuartoDTO tipoQuarto, Model model) {

        String mensagem = tipoQuartoService.criarTipoQuarto(tipoQuarto);

        model.addAttribute("mensagem", mensagem);
        model.addAttribute("tipoQuarto", new TipoQuartoDTO(null, null, null));

        return "tipoQuartos";

    }

    @PostMapping("/buscar")
    public String buscarTipoQuartoPorId(@RequestParam Long id, Model model) {

        TipoQuartoDTO tipoQuarto = tipoQuartoService.buscarTipoQuartoPorId(id);

        model.addAttribute("resultadoBusca", tipoQuarto);
        model.addAttribute("tipoQuarto", new TipoQuartoDTO(null, null, null));

        return "tipoQuartos";

    }

    @PostMapping("/atualizar")
    public String atualizarTipoQuarto(@ModelAttribute TipoQuartoDTO tipoQuarto, Model model) {

        String mensagem = tipoQuartoService.atualizarTipoQuarto(tipoQuarto);

        model.addAttribute("mensagem", mensagem);

        return "tipoQuartos";

    }

    @PostMapping("/excluir")
    public String excluirTipoQuarto(@RequestParam Long id, Model model) {

        String mensagem = tipoQuartoService.excluirTipoQuarto(id);
        model.addAttribute("mensagem", mensagem);

        return "tipoQuartos";

    }

    @PostMapping("/listar")
    public String listarTiposQuarto(Model model) {

        List<TipoQuartoDTO> lista = tipoQuartoService.listarTiposQuarto();

        model.addAttribute("listaTiposQuarto", lista);

        return "tipoQuartos";

    }

}