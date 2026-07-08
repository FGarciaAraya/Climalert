package ar.edu.utn.frba.dds.Climalert.services.clients;

import ar.edu.utn.frba.dds.Climalert.dtos.Mensaje;
import ar.edu.utn.frba.dds.Climalert.models.entities.alertador.AlertadorMail;
import ar.edu.utn.frba.dds.Climalert.models.entities.clima.Clima;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class AlertaClient {

    private static final List<String> interesados = List.of(
            "admin@clima.com",
            "emergencias@clima.com",
            "meteorologia@clima.com"
    );

    private final AlertadorMail alertadorMail;

    public void Alertar(Clima clima){
        interesados.forEach( i ->
                alertadorMail.enviar(new Mensaje(i, toTextoMenasje(clima)))
        );
    }

    private String toTextoMenasje(Clima clima){
        return """
            Alerta meteorológica
            
            Se registraron las siguientes condiciones en %s:

            Temperatura: %.1f °C
            Humedad: %d%%
            Última actualización: %s
            """
                .formatted(
                    clima.getCiudad(),
                    clima.getTempActual(),
                    clima.getHumedadActual(),
                    clima.getUltimaAct()
                );

    }
}
