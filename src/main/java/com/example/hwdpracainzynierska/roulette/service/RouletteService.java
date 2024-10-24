package com.example.hwdpracainzynierska.roulette.service;

import com.example.hwdpracainzynierska.roulette.history.RouletteHistory;
import com.example.hwdpracainzynierska.roulette.history.repository.RouletteHistoryRepository;
import com.example.hwdpracainzynierska.roulette.model.Roulette;
import com.example.hwdpracainzynierska.roulette.request.RouletteRequest;
import com.example.hwdpracainzynierska.roulette.response.RouletteResponse;
import com.example.hwdpracainzynierska.user.model.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service

public class RouletteService {
    private Roulette roulette;
    private RouletteHistoryRepository rouletteHistoryRepository;

    public RouletteService(Roulette roulette, RouletteHistoryRepository rouletteHistoryRepository){
        this.roulette = roulette;
        this.rouletteHistoryRepository = rouletteHistoryRepository;
        roulette.runPrng();
    }

    public int getOutput(){
        return roulette.getCurrentRandomNumber();
    }

    //bet number is specific for every bet type ex. RedBlack, 1 (black)
    public RouletteResponse placeBet(RouletteRequest request, User user){
        int currRandNumber = roulette.getCurrentRandomNumber();
        String betType = request.getBetType();
        int betVersion = request.getBetVersion();
        boolean result = false;
        switch (betType){
            case "RedBlack":
                result = roulette.redBlackBet(currRandNumber, betVersion);
                break;
            case "Dozen":
                result = roulette.dozenBet(currRandNumber, betVersion);
                break;
            case "StraightUp":
                result = roulette.straightUpBet(currRandNumber, betVersion);
                break;
        }

        rouletteHistoryRepository.save(
                RouletteHistory.builder()
                        .user(user)
                        .betType(betType)
                        .betVersion(betVersion)
                        .resultNumber(currRandNumber)
                        .result(result)
                        .betValue(0)
                        .winValue(0)
                        .build()
        );

        return RouletteResponse.builder()
                .game("Roulette")
                .userId(user.getId())
                .betType(betType)
                .generatedNumber(currRandNumber)
                .betVersion(betVersion)
                .result(result)
                .build();
    }
}
