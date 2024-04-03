package com.preferences.persistence;

import com.commons.client.model.ClientPreferences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientPreferencesRespository extends JpaRepository<ClientPreferences, Long> {
}
