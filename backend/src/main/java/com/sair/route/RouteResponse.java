package com.sair.route;

import java.util.UUID;

public record RouteResponse(
        UUID id,
        String name,
        double originLat,
        double originLng,
        double destLat,
        double destLng,
        String morningDeparture,
        String eveningDeparture,
        boolean notifyEnabled
) {
    static RouteResponse from(SavedRoute r) {
        return new RouteResponse(r.getId(), r.getName(),
                r.getOriginLat(), r.getOriginLng(),
                r.getDestLat(), r.getDestLng(),
                r.getMorningDeparture(), r.getEveningDeparture(),
                r.isNotifyEnabled());
    }
}
