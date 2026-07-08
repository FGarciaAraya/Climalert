package ar.edu.utn.frba.dds.Climalert.models.entities.alertador;

import ar.edu.utn.frba.dds.Climalert.dtos.Mensaje;

public interface AlertadorMail {
    void enviar(Mensaje mensaje);
}
