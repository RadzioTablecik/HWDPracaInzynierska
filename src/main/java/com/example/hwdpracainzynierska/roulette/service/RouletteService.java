package com.example.hwdpracainzynierska.roulette.service;

import com.example.hwdpracainzynierska.roulette.model.Roulette;
import com.example.hwdpracainzynierska.roulette.request.RouletteRequest;
import com.example.hwdpracainzynierska.roulette.response.RouletteResponse;
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

    //bet number is specific for every bet type ex. RedBlack, 1 (black)
    public RouletteResponse placeBet(RouletteRequest request){
        int currRandNumber = roulette.getCurrentRandomNumber();
        String betType = request.getBetType();
        int betValue = request.getBetValue();
        boolean result = false;
        switch (betType){
            case "RedBlack":
                result = roulette.redBlackBet(currRandNumber, betValue);
                break;
            case "Dozen":
                result = roulette.dozenBet(currRandNumber, betValue);
                break;
            case "StraightUp":
                result = roulette.straightUpBet(currRandNumber, betValue);
                break;
        }

        return RouletteResponse.builder()
                .game("Roulette")
                .betType(betType)
                .generatedNumber(currRandNumber)
                .betValue(betValue)
                .result(result)
                .build();
    }
}
