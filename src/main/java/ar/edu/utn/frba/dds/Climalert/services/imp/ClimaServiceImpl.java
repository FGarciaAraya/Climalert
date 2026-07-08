package ar.edu.utn.frba.dds.Climalert.services.imp;

import ar.edu.utn.frba.dds.Climalert.dtos.clima.ClimaResponse;
import ar.edu.utn.frba.dds.Climalert.dtos.temperatura.Situacion;
import ar.edu.utn.frba.dds.Climalert.models.entities.clima.Clima;
import ar.edu.utn.frba.dds.Climalert.models.entities.clima.Estado;
import ar.edu.utn.frba.dds.Climalert.models.entities.mapper.ClimaMapper;
import ar.edu.utn.frba.dds.Climalert.models.repositories.ClimaRepository;
import ar.edu.utn.frba.dds.Climalert.services.ClimaService;
import ar.edu.utn.frba.dds.Climalert.services.clients.AlertaClient;
import ar.edu.utn.frba.dds.Climalert.services.clients.WeatherAPIClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ClimaServiceImpl implements ClimaService {

    private final WeatherAPIClient weatherAPIClient;
    private final AlertaClient alertaClient;

    private final ClimaRepository repository;

    private Clima getClima() {
        Situacion actual = weatherAPIClient.getClima();

        if(actual == null)
            throw new RuntimeException("el clima actual fallo");

        Clima climaActual = Clima
                .builder()
                .id(actual.id())
                .ciudad(actual.name())
                .tempActual(actual.temperatura())
                .humedadActual(actual.humedad())
                .datos(new ArrayList<>())
                .build();
        climaActual.calcularEstado();
        return climaActual;
    }

    // Cada 1 minuto, el Sistema deberá analizar la última información disponible del clima.
    // (Con esto entiendo de que analiza, pero no guarda, solo cada 5 minutos guarda el estado)
    @Override
    public void AnalizarClima() {
        Clima clima = getClima();

        if(clima.calcularEstado() == Estado.ALERTA)
            alertaClient.Alertar(clima);
    }


    // Cada 5 minutos, el Sistema deberá obtener los datos climáticos actuales y almacenarlos
    // localmente para registro histórico y análisis posterior.
    @Override
    public void SaveClima() {
        Clima clima = getClima();

        Optional<Clima> climaViejoOpt = repository.FindById(clima.getId());

        // la primera vez que se registra
        if(climaViejoOpt.isEmpty()){
            repository.Save(clima);
            return;
        }

        Clima climaViejo = climaViejoOpt.get();
        climaViejo.ActualizarClima(clima);

        repository.Save(climaViejo);
    }

    @Override
    public ClimaResponse FindClimaById(String id) {
        Clima clima = repository.FindById(id).orElseThrow(() -> new RuntimeException("el clima no existe"));
        return ClimaMapper.toResponse(clima);
    }
}
