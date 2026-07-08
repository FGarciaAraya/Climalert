package ar.edu.utn.frba.dds.Climalert.models.repositories.imp;

import ar.edu.utn.frba.dds.Climalert.models.entities.clima.Clima;
import ar.edu.utn.frba.dds.Climalert.models.repositories.ClimaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ClimaRepositoryImpl implements ClimaRepository {
    private List<Clima> climas = new ArrayList<>();

    @Override
    public Clima Save(Clima clima) {
        if(climas.stream().noneMatch(c -> c.getId().equals(clima.getId())))
            climas.add(clima);
        return clima;
    }

    @Override
    public Optional<Clima> FindById(String id) {
        return climas.stream().filter(c -> c.getId().equals(id)).findFirst();
    }
}
