package com.example.hwdpracainzynierska.roulette.history;

import com.example.hwdpracainzynierska.user.model.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "roulette_history")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RouletteHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;
    private String betType;
    private Integer betVersion;
    private Integer resultNumber;
    private Boolean result;
    private Integer betValue;
    private Integer winValue;
}
