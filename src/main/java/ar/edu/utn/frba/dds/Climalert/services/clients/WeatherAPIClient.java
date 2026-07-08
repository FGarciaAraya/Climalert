package ar.edu.utn.frba.dds.Climalert.services.clients;


import ar.edu.utn.frba.dds.Climalert.dtos.temperatura.Situacion;
import ar.edu.utn.frba.dds.Climalert.dtos.weatherAPI.WeatherResponse;
import ar.edu.utn.frba.dds.Climalert.models.entities.mapper.WeatherMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@AllArgsConstructor
public class WeatherAPIClient {

    private final RestTemplate template = new RestTemplate();

    private final String url = "https://api.weatherapi.com/v1";

    private final String apiKey = "";

    private final String localidad = "Buenos%20Aires";


    public Situacion getClima() {
        String reqUrl = UriComponentsBuilder
                .fromUriString(this.url + "/current.json")
                .queryParam("q", localidad)
                .queryParam("key", apiKey)
                .build()
                .toUriString();

        WeatherResponse res = template.getForObject(reqUrl, WeatherResponse.class);



        if(res != null)
            return WeatherMapper.toSituacion(res);


        return null;
    }
}
