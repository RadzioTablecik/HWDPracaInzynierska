package com.example.hwdpracainzynierska.roulette.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PrngResponse {
    private String game;
    private int generatedNumber;
}
