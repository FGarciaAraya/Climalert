package ar.edu.utn.frba.dds.Climalert.dtos.temperatura;

import java.time.LocalDateTime;

public record Situacion(
    String id,
    String name,
    String timeStamp,
    Double temperatura,
    Integer humedad
) {}
