package ar.edu.utn.frba.dds.Climalert.dtos.clima;

import java.time.LocalDateTime;
import java.util.List;

public record ClimaResponse(
        String id,
        String ciudad,

        Double temperatura,
        Integer humedad,
        String ultimaAct,
        List<DatoResponse> historial
) {
}
