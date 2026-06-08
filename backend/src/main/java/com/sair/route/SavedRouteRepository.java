package com.sair.route;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SavedRouteRepository extends JpaRepository<SavedRoute, UUID> {
    List<SavedRoute> findByUserId(UUID userId);
    Optional<SavedRoute> findByIdAndUserId(UUID id, UUID userId);
    List<SavedRoute> findByNotifyEnabledTrue();
}
