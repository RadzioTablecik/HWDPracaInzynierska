package com.example.hwdpracainzynierska.roulette.service;

import com.example.hwdpracainzynierska.roulette.model.Roulette;
import org.springframework.stereotype.Service;

@Service
public class RouletteService {
    private Roulette roulette;

    public RouletteService(Roulette roulette){
        this.roulette = roulette;
        roulette.runPrng();
    }

    public int getOutput(){
        return roulette.getCurrentRandomNumber();
    }
}
