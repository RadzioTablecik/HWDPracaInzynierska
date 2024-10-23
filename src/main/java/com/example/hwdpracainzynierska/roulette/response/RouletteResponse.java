package com.example.hwdpracainzynierska.roulette.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RouletteResponse {
    private String game;
    private String betType;
    private int generatedNumber;
    private int betValue;
    private boolean result;
}
