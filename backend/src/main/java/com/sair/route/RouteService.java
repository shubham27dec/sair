package com.sair.route;

import com.sair.user.User;
import com.sair.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RouteService {

    private final SavedRouteRepository routeRepository;
    private final UserRepository userRepository;

    public List<RouteResponse> listRoutes(UUID userId) {
        return routeRepository.findByUserId(userId).stream()
                .map(RouteResponse::from)
                .toList();
    }

    public RouteResponse saveRoute(UUID userId, RouteRequest request) {
        User user = userRepository.getReferenceById(userId);
        SavedRoute route = new SavedRoute();
        route.setUser(user);
        route.setName(request.name());
        route.setOriginLat(request.originLat());
        route.setOriginLng(request.originLng());
        route.setDestLat(request.destLat());
        route.setDestLng(request.destLng());
        route.setMorningDeparture(request.morningDeparture());
        route.setEveningDeparture(request.eveningDeparture());
        route.setNotifyEnabled(request.notifyEnabled());
        return RouteResponse.from(routeRepository.save(route));
    }

    public void deleteRoute(UUID userId, UUID routeId) {
        SavedRoute route = routeRepository.findByIdAndUserId(routeId, userId)
                .orElseThrow(() -> new IllegalArgumentException("Route not found"));
        routeRepository.delete(route);
    }
}
