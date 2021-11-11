package com.example.aula19.service;

import com.example.aula19.model.Paciente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PacienteService {

    List<Paciente> pacientes = new ArrayList<>();

    public PacienteService() {
        instanciarPacientes();
    }

    private void instanciarPacientes(){
        Paciente p = new Paciente("Jose", "Pacheco", "jose@mail.com", "564.851.247-68");
        pacientes.add(p);
        p = new Paciente("Joao", "Santos", "joao@mail.com","395.851.247-48");
        pacientes.add(p);
        p = new Paciente("Maria", "Silva", "maria@mail.com", "759.851.247-75");
        pacientes.add(p);
        p = new Paciente("Tereza", "Santos", "tereza@mail.com", "658.851.247-79");
        pacientes.add(p);
        p = new Paciente("Marcia", "Carvalho", "marcia@mail.com", "648.851.247-13");
        pacientes.add(p);
        p = new Paciente("Joao", "Teixeira", "paula@mail.com", "815.851.247-15");
        pacientes.add(p);
    };

    public List<Paciente> todos(){
        return pacientes;
    }

    public Paciente buscarPorEmail(String email){
        for (Paciente p : pacientes){
            if(p.getEmail().equalsIgnoreCase(email))
                return p;
        }
        return null;
    }

}
