package com.example.Trainer.controler;

import com.example.Trainer.model.Trainer;
import com.example.Trainer.service.impl.TrainerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TrainerControler {
    private final TrainerService trainerService;

    public TrainerControler() {
        this.trainerService = new TrainerService();
    }

    @GetMapping("/trainer")
    public List<Trainer> getList(){
        return trainerService.getList();
    }
}
