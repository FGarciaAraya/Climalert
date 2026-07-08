package ar.edu.utn.frba.dds.Climalert.models.repositories;

import ar.edu.utn.frba.dds.Climalert.models.entities.clima.Clima;

import java.util.Optional;

public interface ClimaRepository {
    Clima Save(Clima clima);

    Optional<Clima> FindById(String id);
}
