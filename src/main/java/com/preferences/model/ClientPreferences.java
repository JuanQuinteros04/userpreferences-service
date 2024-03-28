package com.preferences.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "user_preferences")
@EqualsAndHashCode
@Entity
public class ClientPreferences {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_id")
    private Long clientId;

    @Column(name = "type_room")
    private String typeRoom;

    @Column(name = "number_people")
    private Long numberPeople;

    @Column(name = "price")
    private Double price;

}
