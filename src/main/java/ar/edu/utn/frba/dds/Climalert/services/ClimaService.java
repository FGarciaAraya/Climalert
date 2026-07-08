package ar.edu.utn.frba.dds.Climalert.services;

import ar.edu.utn.frba.dds.Climalert.dtos.clima.ClimaResponse;

public interface ClimaService {

    void AnalizarClima();
    void SaveClima();

    ClimaResponse FindClimaById(String id);
}
