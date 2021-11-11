package com.example.aula19.controller;

import com.example.aula19.model.Paciente;
import com.example.aula19.service.PacienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PacienteController {

    PacienteService pacienteService = new PacienteService();

    @GetMapping("/index")
    public String index(){ return "index"; }

    @GetMapping("/paciente")
    public String index(@RequestParam("email") String email, Model model){
        Paciente p = pacienteService.buscarPorEmail(email);
        model.addAttribute("nome", p.getNome());
        model.addAttribute("sobrenome", p.getSobrenome());
        model.addAttribute("email", p.getEmail());
        return "paciente";
    }

    @GetMapping("listaPacientes")
    public String listaPacientes(Model model){
        List<Paciente> pacientes = pacienteService.todos();
        int count = 1;
        for ( Paciente p : pacientes ) {
            model.addAttribute("nome" + count, p.getNome());
            model.addAttribute("sobrenome" + count, p.getSobrenome());
            model.addAttribute("email" + count, p.getEmail());
            model.addAttribute("cpf" + count, p.getCpf());
            count++;
        }
        return "listaPacientes";
    }

}
