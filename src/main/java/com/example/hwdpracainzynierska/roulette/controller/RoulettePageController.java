package com.example.hwdpracainzynierska.roulette.controller;

import com.example.hwdpracainzynierska.roulette.model.Roulette;
import com.example.hwdpracainzynierska.roulette.service.RouletteService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoulettePageController {

    RouletteService rouletteService;

    public RoulettePageController(RouletteService rouletteService){
        this.rouletteService = rouletteService;
    }

    @GetMapping("/roulette")
    public ResponseEntity<Integer> showResult(){
        return ResponseEntity.ok(rouletteService.getOutput());
    }

}
