package com.preferences.persistence;

import com.preferences.model.ClientPreferences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientPreferencesRespository extends JpaRepository<ClientPreferences, Long> {
}
