package br.edu.fateczl.hotel.controller;

import br.edu.fateczl.hotel.service.HospedagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/hospedagem")
public class HospedagemController {

    @Autowired
    private HospedagemService hospedagemService;

    @GetMapping
    public String carregarForm(Model model) {
        model.addAttribute("hospedagem", new HospedagemDTO(null, null, null, null, null));
        model.addAttribute("mensagem", null);
        model.addAttribute("resultadoBusca", null);
        model.addAttribute("listaHospedagems", null);
        return "hospedagems";
    }

    @PostMapping("/criar")
    public String criarHospedagem(@ModelAttribute @Valid HospedagemDTO hospedagem, Model model) {
        String mensagem = hospedagemService.criarHospedagem(hospedagem);
        model.addAttribute("mensagem", mensagem);
        model.addAttribute("hospedagem", new HospedagemDTO(null, null, null, null, null));
        return "hospedagems";
    }

    @PostMapping("/buscar")
    public String buscarHospedagemPorId(@RequestParam Long id, Model model) {
        HospedagemDTO hospedagem = hospedagemService.buscarHospedagemPorId(id);
        model.addAttribute("resultadoBusca", hospedagem);
        model.addAttribute("hospedagem", new HospedagemDTO(null, null, null, null, null));
        return "hospedagems";
    }

    @PostMapping("/atualizar")
    public String atualizarHospedagem(@ModelAttribute @Valid HospedagemDTO hospedagem, Model model) {
        String mensagem = hospedagemService.atualizarHospedagem(hospedagem);
        model.addAttribute("mensagem", mensagem);
        return "hospedagems";
    }

    @PostMapping("/excluir")
    public String excluirHospedagem(@RequestParam Long id, Model model) {
        String mensagem = hospedagemService.excluirHospedagem(id);
        model.addAttribute("mensagem", mensagem);
        return "hospedagems";
    }

    @PostMapping("/listar")
    public String listarHospedagems(Model model) {
        List<HospedagemDTO> lista = hospedagemService.listarHospedagems();
        model.addAttribute("listaHospedagems", lista);
        return "hospedagems";
    }

}