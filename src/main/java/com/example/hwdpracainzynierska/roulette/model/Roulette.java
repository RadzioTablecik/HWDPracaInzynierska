package com.example.hwdpracainzynierska.roulette.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Getter
@Setter
@Component
public class Roulette{
    private int currentRandomNumber;
    private int betType;
    private int bid;

    public Roulette(){
    }


    @Async
    public void runPrng() {
        SecureRandom secureRandom = new SecureRandom();
        while (true) {
            currentRandomNumber = secureRandom.nextInt(37);
        }
    }

}
