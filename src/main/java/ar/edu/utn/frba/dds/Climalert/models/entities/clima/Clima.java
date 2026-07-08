package ar.edu.utn.frba.dds.Climalert.models.entities.clima;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class Clima {
    private String id;
    private String ciudad;

    private Double tempActual;
    private Integer humedadActual;
    private String ultimaAct;

    private Estado estado;
    private List<Datos> datos;

    public void ActualizarClima(Clima clima){
        datos.add(new Datos(
                ultimaAct,
                estado,
                humedadActual,
                tempActual
        ));

        ultimaAct       = clima.ultimaAct;
        estado          = clima.estado;
        humedadActual   = clima.humedadActual;
        tempActual      = clima.tempActual;
    }

    public Estado calcularEstado(){
        estado = Clima.calcularEstado(this);
        return estado;
    }

    public static Estado calcularEstado(Clima clima){
        if(clima.humedadActual >= 60 && clima.tempActual >= 35)
            return Estado.ALERTA;
        return Estado.NORMAL;
    }
}
