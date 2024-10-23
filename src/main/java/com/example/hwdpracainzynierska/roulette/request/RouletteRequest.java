package com.example.hwdpracainzynierska.roulette.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RouletteRequest {
    private String betType;
    private int betValue;
}
