package ar.edu.utn.frba.dds.Climalert.models.entities.alertador;

import ar.edu.utn.frba.dds.Climalert.dtos.Mensaje;
import org.springframework.stereotype.Component;

@Component
public class AlertadorMailImpl implements AlertadorMail {

    @Override
    public void enviar(Mensaje mensaje) {
        // aca se encontraría la lógica de mensaje
    }
}
