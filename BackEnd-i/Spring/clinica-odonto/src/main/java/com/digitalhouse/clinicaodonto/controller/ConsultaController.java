package com.digitalhouse.clinicaodonto.controller;

import com.digitalhouse.clinicaodonto.configuration.ConfigurationJDBC;
import com.digitalhouse.clinicaodonto.model.Consulta;
import com.digitalhouse.clinicaodonto.model.Dentista;
import com.digitalhouse.clinicaodonto.model.Paciente;
import com.digitalhouse.clinicaodonto.service.ConsultaService;
import com.digitalhouse.clinicaodonto.service.DentistaService;
import com.digitalhouse.clinicaodonto.service.PacienteService;
import com.digitalhouse.clinicaodonto.service.impl.ConsultaServiceImpl;
import com.digitalhouse.clinicaodonto.service.impl.DentistaServiceImpl;
import com.digitalhouse.clinicaodonto.service.impl.EnderecoServiceImpl;
import com.digitalhouse.clinicaodonto.service.impl.PacienteServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {
    private final ConsultaService consultaService = new ConsultaService(
            new ConsultaServiceImpl());

    private final PacienteService pacienteService = new PacienteService(
            new PacienteServiceImpl(new EnderecoServiceImpl()));

    private final DentistaService dentistaService = new DentistaService(
            new DentistaServiceImpl( new ConfigurationJDBC()));

    @PostMapping
    public ResponseEntity<Consulta> cadastrar(@RequestBody Consulta consulta){
        Paciente paciente = consulta.getPaciente();
        Dentista dentista = consulta.getDentista();

        if(paciente != null &&
                pacienteService.buscar(paciente.getId()).isPresent() &&
                dentista != null &&
                dentistaService.buscar(dentista.getId()).isPresent()){
            return ResponseEntity.ok(consultaService.cadastrar(consulta));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consulta> buscar(@PathVariable Integer id){
        return ResponseEntity.ok(consultaService.buscar(id).orElse(null));
    }

    @GetMapping
    public ResponseEntity<List<Consulta>> buscarTodos(){
        return ResponseEntity.ok(consultaService.buscarTodos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Integer id){
        ResponseEntity<String> response;
        if(consultaService.buscar(id).isPresent()){
            consultaService.excluir(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @PutMapping()
    public ResponseEntity<Consulta> atualizar(@RequestBody Consulta consulta){
        ResponseEntity<Consulta> response;
        if(consulta.getIdConsulta() != null && consultaService.buscar(consulta.getIdConsulta()).isPresent()){
            response = ResponseEntity.ok(consultaService.atualizar(consulta));
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }
}
