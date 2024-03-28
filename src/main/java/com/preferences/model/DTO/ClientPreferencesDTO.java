package com.preferences.model.DTO;

import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
@EqualsAndHashCode
public class ClientPreferencesDTO {

    private Long clientId;

    private String typeRoom;

    private Long numberPeople;

    private Double price;

}