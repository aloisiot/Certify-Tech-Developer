package com.example.Trainer.service.impl;

import com.example.Trainer.model.Trainer;
import com.example.Trainer.service.IService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TrainerService implements IService {
    @Override
    public List<Trainer> getList() {
        return Arrays.asList(new Trainer("Ana"), new Trainer("Pedro"));
    }
}
