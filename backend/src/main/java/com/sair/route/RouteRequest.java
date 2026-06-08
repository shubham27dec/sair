package com.sair.route;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record RouteRequest(
        @NotBlank String name,
        double originLat,
        double originLng,
        double destLat,
        double destLng,
        @Pattern(regexp = "^([01]\\d|2[0-3]):[0-5]\\d$", message = "Must be HH:mm") String morningDeparture,
        @Pattern(regexp = "^([01]\\d|2[0-3]):[0-5]\\d$", message = "Must be HH:mm") String eveningDeparture,
        boolean notifyEnabled
) {}
