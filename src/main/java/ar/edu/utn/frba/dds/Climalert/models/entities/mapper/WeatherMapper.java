package ar.edu.utn.frba.dds.Climalert.models.entities.mapper;

import ar.edu.utn.frba.dds.Climalert.dtos.temperatura.Situacion;
import ar.edu.utn.frba.dds.Climalert.dtos.weatherAPI.WeatherResponse;

public class WeatherMapper {
    public static Situacion toSituacion(WeatherResponse response){
        return new Situacion(
                response.location().tz_id(),
                response.location().name(),
                response.current().last_updated(),
                response.current().temp_c(),
                response.current().humidity()
        );
    }
}
