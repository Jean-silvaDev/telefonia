package bcc.ifsuldeminas.sistemaDeTelefonia.controller.comercial;

import bcc.ifsuldeminas.sistemaDeTelefonia.model.entities.repositories.comercial.PlanoRepository;
import bcc.ifsuldeminas.sistemaDeTelefonia.model.entities.telefonia.comercial.Plano;
import org.springframework.web.bind.annotation.*;

//Nome: Jean Francisco Da Silva

@RestController
@RequestMapping("/plano")
public class PlanoController {
    PlanoRepository planoRepository;

    public PlanoController(PlanoRepository planoRepository){
        this.planoRepository = planoRepository;
    }

    @GetMapping
    public Plano listarPlanos(){
        return new Plano();
    }

    @PostMapping
    public Plano criarPlano(@RequestBody Plano plano){
        this.planoRepository.save(plano);
        return plano;
    }
}