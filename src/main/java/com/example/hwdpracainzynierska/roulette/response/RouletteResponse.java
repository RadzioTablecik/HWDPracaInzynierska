package com.example.hwdpracainzynierska.roulette.response;

import com.example.hwdpracainzynierska.user.model.User;
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
    private Long userId;
    private String betType;
    private int generatedNumber;
    private int betVersion;
    private boolean result;
}
