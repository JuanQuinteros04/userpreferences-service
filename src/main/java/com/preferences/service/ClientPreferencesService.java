package com.preferences.service;

import com.preferences.model.DTO.ClientPreferencesDTO;
import com.preferences.model.DTO.ClientPreferencesResponse;

import java.util.List;

public interface ClientPreferencesService {

    List<ClientPreferencesResponse> findAll();

    ClientPreferencesResponse findById(Long id);

    ClientPreferencesResponse createClientPreferences(ClientPreferencesDTO userPreferencesDTO);

    void updateClientPreferences(Long id, ClientPreferencesDTO userPreferencesDTO);

    void deleteClientPreferences(Long id);
}