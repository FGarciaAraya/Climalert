package ar.edu.utn.frba.dds.Climalert.models.entities.mapper;

import ar.edu.utn.frba.dds.Climalert.dtos.clima.ClimaResponse;
import ar.edu.utn.frba.dds.Climalert.dtos.clima.DatoResponse;
import ar.edu.utn.frba.dds.Climalert.models.entities.clima.Clima;
import ar.edu.utn.frba.dds.Climalert.models.entities.clima.Datos;

public class ClimaMapper {

    public static ClimaResponse toResponse(Clima clima){
        return new ClimaResponse(
                clima.getId(),
                clima.getCiudad(),
                clima.getTempActual(),
                clima.getHumedadActual(),
                clima.getUltimaAct(),
                clima.getDatos().stream().map(ClimaMapper::toResponse).toList()
        );
    }

    public static DatoResponse toResponse(Datos dato){
        return new DatoResponse(
                dato.getTimeStamp(),
                dato.getHumedad(),
                dato.getTemperatura()
        );
    }
}
