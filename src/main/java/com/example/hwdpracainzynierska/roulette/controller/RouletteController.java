package com.example.hwdpracainzynierska.roulette.controller;

import com.example.hwdpracainzynierska.roulette.request.RouletteRequest;
import com.example.hwdpracainzynierska.roulette.response.PrngResponse;
import com.example.hwdpracainzynierska.roulette.response.RouletteResponse;
import com.example.hwdpracainzynierska.roulette.service.RouletteService;
import com.example.hwdpracainzynierska.user.model.User;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/roulette")
public class RouletteController {
    RouletteService rouletteService;

    @GetMapping("/prng")
    public ResponseEntity<PrngResponse> showResult(){
        return ResponseEntity.ok(rouletteService.getOutput());
    }

    @PostMapping()
    public ResponseEntity<RouletteResponse> placeBet(
            @RequestBody RouletteRequest request
    ){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currUser = (User) authentication.getPrincipal();
        return ResponseEntity.ok(rouletteService.placeBet(request, currUser));
    }

}
