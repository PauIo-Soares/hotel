package br.edu.fateczl.hotel.controller;

import br.edu.fateczl.hotel.dto.ClienteDTO;
import br.edu.fateczl.hotel.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public String carregarForm(Model model) {
        model.addAttribute("Cliente", new ClienteDTO(null, null, null, null, null));
        model.addAttribute("mensagem", null);
        model.addAttribute("resultadoBusca", null);
        model.addAttribute("listaClientes", null);
        return "Clientes";
    }

    @PostMapping("/criar")
    public String criarCliente(@ModelAttribute @Valid ClienteDTO cliente, Model model) {
        String mensagem = clienteService.criarCliente(cliente);
        model.addAttribute("mensagem", mensagem);
        model.addAttribute("Cliente", new ClienteDTO(null, null, null, null, null));
        return "Clientes";
    }

    @PostMapping("/buscar")
    public String buscarClientePorId(@RequestParam Long id, Model model) {
        ClienteDTO cliente = clienteService.buscarClientePorId(id);
        model.addAttribute("resultadoBusca", cliente);
        model.addAttribute("Cliente", new ClienteDTO(null, null, null, null, null));
        return "Clientes";
    }

    @PostMapping("/atualizar")
    public String atualizarCliente(@ModelAttribute @Valid ClienteDTO cliente, Model model) {
        String mensagem = clienteService.atualizarCliente(cliente);
        model.addAttribute("mensagem", mensagem);
        return "Clientes";
    }

    @PostMapping("/excluir")
    public String excluirCliente(@RequestParam Long id, Model model) {
        String mensagem = clienteService.excluirCliente(id);
        model.addAttribute("mensagem", mensagem);
        return "Clientes";
    }

    @PostMapping("/listar")
    public String listarClientes(Model model) {
        List<ClienteDTO> lista = clienteService.listarClientes();
        model.addAttribute("listaClientes", lista);
        return "Clientes";
    }

}