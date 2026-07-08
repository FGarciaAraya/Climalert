package ar.edu.utn.frba.dds.Climalert.models.entities.clima;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@Setter
@Getter
public class Datos {
    private String timeStamp;
    private Estado estado;
    private Integer humedad;
    private Double temperatura;
}
