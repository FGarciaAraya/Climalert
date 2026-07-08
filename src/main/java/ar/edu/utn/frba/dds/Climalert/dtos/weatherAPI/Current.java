package ar.edu.utn.frba.dds.Climalert.dtos.weatherAPI;

public record Current (
    String last_updated,
    Double temp_c,
    Integer humidity
){}
