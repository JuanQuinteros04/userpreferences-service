package com.preferences.service;

import com.preferences.exception.NotFoundException;
import com.preferences.model.ClientPreferences;
import com.preferences.model.DTO.ClientPreferencesDTO;
import com.preferences.model.DTO.ClientPreferencesResponse;
import com.preferences.model.mapper.ClientPreferencesMapper;
import com.preferences.persistence.ClientPreferencesRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientPreferencesServiceImpl implements ClientPreferencesService{

    @Autowired
    ClientPreferencesRespository clientPreferencesRepository;

    ClientPreferencesMapper clientPreferencesMapper = ClientPreferencesMapper.INSTANCE;

    @Override
    public List<ClientPreferencesResponse> findAll() {
        return clientPreferencesRepository.findAll().stream().map(userPreferences -> clientPreferencesMapper.clientPreferencesToClientPreferencesResponse(userPreferences)).collect(Collectors.toList());
    }

    @Override
    public ClientPreferencesResponse findById(Long id) {
        return clientPreferencesMapper.clientPreferencesToClientPreferencesResponse(clientPreferencesRepository.findById(id).orElseThrow(NotFoundException::new));
    }

    @Override
    public ClientPreferencesResponse createClientPreferences(ClientPreferencesDTO userPreferencesDTO) {
        ClientPreferences clientPreferences = clientPreferencesMapper.clientPreferencesDTOToClientPreferences(userPreferencesDTO);
        clientPreferencesRepository.save(clientPreferences);
        return clientPreferencesMapper.clientPreferencesToClientPreferencesResponse(clientPreferences);
    }

    @Override
    public void updateClientPreferences(Long id, ClientPreferencesDTO clientPreferencesDTO) {
        ClientPreferences clientPreferences = clientPreferencesRepository.findById(id).orElseThrow(NotFoundException::new);

        clientPreferences.setClientId(clientPreferencesDTO.getClientId() != null ? clientPreferencesDTO.getClientId() : clientPreferences.getClientId());
        clientPreferences.setTypeRoom(clientPreferencesDTO.getTypeRoom() != null ? clientPreferencesDTO.getTypeRoom() : clientPreferences.getTypeRoom());
        clientPreferences.setNumberPeople(clientPreferencesDTO.getNumberPeople() != null ? clientPreferencesDTO.getNumberPeople() : clientPreferences.getNumberPeople());
        clientPreferences.setPrice(clientPreferencesDTO.getPrice() != null ? clientPreferencesDTO.getPrice() : clientPreferences.getPrice());

        clientPreferencesRepository.save(clientPreferences);
    }

    @Override
    public void deleteClientPreferences(Long id) {
        clientPreferencesRepository.delete(clientPreferencesRepository.findById(id).orElseThrow(NotFoundException::new));
    }

}
