package com.preferences.service;

import com.commons.client.model.DTO.ClientPreferencesDTO;
import com.commons.client.model.DTO.ClientPreferencesResponse;
import java.util.List;

public interface ClientPreferencesService {

    List<ClientPreferencesResponse> findAll();

    ClientPreferencesResponse findById(Long id);

    ClientPreferencesResponse createClientPreferences(ClientPreferencesDTO userPreferencesDTO);

    void updateClientPreferences(Long id, ClientPreferencesDTO userPreferencesDTO);

    void deleteClientPreferences(Long id);
}