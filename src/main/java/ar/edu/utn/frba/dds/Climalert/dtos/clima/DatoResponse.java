package ar.edu.utn.frba.dds.Climalert.dtos.clima;

import java.time.LocalDateTime;

public record DatoResponse(
        String timeStamp,
        Integer humedad,
        Double temperatura
) {
}
