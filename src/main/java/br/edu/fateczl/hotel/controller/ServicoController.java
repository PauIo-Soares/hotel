package br.edu.fateczl.hotel.controller;

import br.edu.fateczl.hotel.dto.ServicoDTO;
import br.edu.fateczl.hotel.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/servico")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @GetMapping
    public String carregarForm(Model model) {

        model.addAttribute("servico", new ServicoDTO(null, null, null, null, null));
        model.addAttribute("mensagem", null);
        model.addAttribute("resultadoBusca", null);
        model.addAttribute("listaServicos", null);

        return "servicos";

    }

    @PostMapping("/criar")
    public String criarServico(@ModelAttribute ServicoDTO servico, Model model) {

        String mensagem = servicoService.criarServico(servico);

        model.addAttribute("mensagem", mensagem);
        model.addAttribute("servico", new ServicoDTO(null, null, null, null, null));

        return "servicos";

    }

    @PostMapping("/buscar")
    public String buscarServicoPorId(@RequestParam Long id, Model model) {

        ServicoDTO servico = servicoService.buscarServicoPorId(id);

        model.addAttribute("resultadoBusca", servico);
        model.addAttribute("servico", new ServicoDTO(null, null, null, null, null));

        return "servicos";

    }

    @PostMapping("/atualizar")
    public String atualizarServico(@ModelAttribute ServicoDTO servico, Model model) {

        String mensagem = servicoService.atualizarServico(servico);

        model.addAttribute("mensagem", mensagem);

        return "servicos";

    }

    @PostMapping("/excluir")
    public String excluirServico(@RequestParam Long id, Model model) {

        String mensagem = servicoService.excluirServico(id);

        model.addAttribute("mensagem", mensagem);

        return "servicos";

    }

    @PostMapping("/listar")
    public String listarServicos(Model model) {

        List<ServicoDTO> lista = servicoService.listarServicos();

        model.addAttribute("listaServicos", lista);

        return "servicos";

    }

}