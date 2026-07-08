package ar.edu.utn.frba.dds.Climalert.controllers;

import ar.edu.utn.frba.dds.Climalert.dtos.clima.ClimaResponse;
import ar.edu.utn.frba.dds.Climalert.services.ClimaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("climas")
public class ClimaController {
    private final ClimaService service;


    // id -> "America/Argentina/Buenos_Aires"
    @GetMapping
    public ClimaResponse GetStatus(){
        return service.FindClimaById("America/Argentina/Buenos_Aires");
    }
}
