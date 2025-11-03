package br.edu.fateczl.hotel.controller;

import br.edu.fateczl.hotel.dto.ReservaDTO;
import br.edu.fateczl.hotel.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping
    public String carregarForm(Model model) {
        model.addAttribute("reserva", new ReservaDTO(null, null, null, null, null));
        model.addAttribute("mensagem", null);
        model.addAttribute("resultadoBusca", null);
        model.addAttribute("listaReservas", null);
        return "reservas";
    }

    @PostMapping("/criar")
    public String criarReserva(@ModelAttribute @Valid ReservaDTO reserva, Model model) {
        String mensagem = reservaService.criarReserva(reserva);
        model.addAttribute("mensagem", mensagem);
        model.addAttribute("reserva", new ReservaDTO(null, null, null, null, null));
        return "reservas";
    }

    @PostMapping("/buscar")
    public String buscarReservaPorId(@RequestParam Long id, Model model) {
        ReservaDTO reserva = reservaService.buscarReservaPorId(id);
        model.addAttribute("resultadoBusca", reserva);
        model.addAttribute("reserva", new ReservaDTO(null, null, null, null, null));
        return "reservas";
    }

    @PostMapping("/atualizar")
    public String atualizarReserva(@ModelAttribute @Valid ReservaDTO reserva, Model model) {
        String mensagem = reservaService.atualizarReserva(reserva);
        model.addAttribute("mensagem", mensagem);
        return "reservas";
    }

    @PostMapping("/excluir")
    public String excluirReserva(@RequestParam Long id, Model model) {
        String mensagem = reservaService.excluirReserva(id);
        model.addAttribute("mensagem", mensagem);
        return "reservas";
    }

    @PostMapping("/listar")
    public String listarReservas(Model model) {
        List<ReservaDTO> lista = reservaService.listarReservas();
        model.addAttribute("listaReservas", lista);
        return "reservas";
    }

}