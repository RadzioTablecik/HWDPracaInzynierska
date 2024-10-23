package com.example.hwdpracainzynierska.roulette.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.ArrayList;

@Getter
@Setter
@Component
public class Roulette{
    private int currentRandomNumber;

    public Roulette(){

    }


    @Async
    public void runPrng(

    ) {
        SecureRandom secureRandom = new SecureRandom();
        while (true) {
            currentRandomNumber = secureRandom.nextInt(37);
        }
    }

    //color - even(red) "0", odd(black) "1"
    //win 1:1
    public boolean redBlackBet(int resultNumber, int color){
        if (resultNumber == 0){
            return false;
        }
        else {
            if (color == 0){
                if (resultNumber % 2 == 0)
                    return true;
                else
                    return false;
            }
            else {
                if (resultNumber % 2 == 1)
                    return true;
                else
                    return false;
            }
        }
    }

    //dozens 1 -> 1-12, 2 -> 13-24, 3 -> 25-36
    //win 2:1
    public boolean dozenBet(int resultNumber, int dozenNumber){
        if (resultNumber == 0){
            return false;
        }
        else {
            switch (dozenNumber) {
                case 1:
                    if (resultNumber <= 12) {
                        return true;
                    }
                    else
                        return false;
                case 2:
                    if (13 <= resultNumber && resultNumber <= 24) {
                        return true;
                    }
                    else
                        return false;
                case 3:
                    if (resultNumber >= 25) {
                        return true;
                    }
                    else
                        return false;
                default:
                    return false;
            }
        }
    }

    //win 35:1
    public boolean straightUpBet(int resultNumber, int guessedNumber){
        if (resultNumber == guessedNumber)
            return true;
        else
            return false;
    }

}
