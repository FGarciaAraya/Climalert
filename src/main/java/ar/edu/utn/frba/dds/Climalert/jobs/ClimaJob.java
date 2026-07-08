package ar.edu.utn.frba.dds.Climalert.jobs;

import ar.edu.utn.frba.dds.Climalert.services.ClimaService;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ClimaJob {
    private final ClimaService climaService;

    @Scheduled(cron = "0 * * * * *")
    public void AnalizarClima() {
        climaService.AnalizarClima();
    }

    @Scheduled(cron = "0 */5 * * * *")
    public void AlmacenarClima() {
        climaService.SaveClima();
    }
}
