package com.preferences.model.mapper;

import com.preferences.model.ClientPreferences;
import com.preferences.model.DTO.ClientPreferencesDTO;
import com.preferences.model.DTO.ClientPreferencesResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientPreferencesMapper {

    ClientPreferencesMapper INSTANCE = Mappers.getMapper(ClientPreferencesMapper.class);

    @Mapping(target = "id", ignore = true)
    ClientPreferences clientPreferencesDTOToClientPreferences(ClientPreferencesDTO clientPreferences);

    @Mapping(target = "id", ignore = true)
    ClientPreferences clientPreferencesResponseToClientPreferences(ClientPreferencesResponse clientPreferencesResponse);

    ClientPreferencesResponse clientPreferencesToClientPreferencesResponse(ClientPreferences clientPreferences);
}

