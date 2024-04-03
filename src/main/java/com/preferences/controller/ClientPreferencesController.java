package com.preferences.controller;

import com.commons.client.model.DTO.ClientPreferencesDTO;
import com.commons.client.model.DTO.ClientPreferencesResponse;
import com.preferences.service.ClientPreferencesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/client/preferences")
public class ClientPreferencesController {

    @Autowired
    ClientPreferencesService clientPreferencesService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClientPreferencesResponse>> findAll(){
        return ResponseEntity.ok(clientPreferencesService.findAll());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientPreferencesResponse>findById(@PathVariable("id")Long id){
        return ResponseEntity.ok(clientPreferencesService.findById(id));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientPreferencesResponse>createClientPreferences(@RequestBody ClientPreferencesDTO clientPreferencesDTO){
        ClientPreferencesResponse clientPreferencesResponse = clientPreferencesService.createClientPreferences(clientPreferencesDTO);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand((clientPreferencesResponse.getId()))
                .toUri();

        return ResponseEntity.created(location).body(clientPreferencesResponse);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void>updateClientPreferences(@PathVariable("id")Long id, @RequestBody ClientPreferencesDTO clientPreferencesDTO){
        clientPreferencesService.updateClientPreferences(id, clientPreferencesDTO);
        return ResponseEntity.status(204).build();
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void>deleteClientPreferences(@PathVariable("id") Long id){
        clientPreferencesService.deleteClientPreferences(id);
        return ResponseEntity.status(204).build();
    }

}

