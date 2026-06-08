package com.sair.route;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/routes")
@RequiredArgsConstructor
public class RouteController {

    private final RouteService routeService;

    @GetMapping
    public List<RouteResponse> list(@AuthenticationPrincipal String userId) {
        return routeService.listRoutes(UUID.fromString(userId));
    }

    @PostMapping
    public RouteResponse save(@AuthenticationPrincipal String userId,
                              @Valid @RequestBody RouteRequest request) {
        return routeService.saveRoute(UUID.fromString(userId), request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@AuthenticationPrincipal String userId,
                                       @PathVariable UUID id) {
        routeService.deleteRoute(UUID.fromString(userId), id);
        return ResponseEntity.noContent().build();
    }
}
