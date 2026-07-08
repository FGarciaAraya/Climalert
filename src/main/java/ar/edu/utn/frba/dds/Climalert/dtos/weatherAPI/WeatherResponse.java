package ar.edu.utn.frba.dds.Climalert.dtos.weatherAPI;

public record WeatherResponse(
    Location location,
    Current current
) {}
