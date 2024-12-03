package bcc.ifsuldeminas.sistemaDeTelefonia.controller.comercial;

import bcc.ifsuldeminas.sistemaDeTelefonia.model.entities.repositories.comercial.PlanoRepository;
import bcc.ifsuldeminas.sistemaDeTelefonia.model.entities.telefonia.comercial.Plano;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//Nome: Jean Francisco Da Silva

@RestController
@RequestMapping("/plano")
public class PlanoController {
    PlanoRepository planoRepository;

    public PlanoController(PlanoRepository planoRepository){
        this.planoRepository = planoRepository;
    }

    @GetMapping
    public List<Plano> listarPlanos(){
        return this.planoRepository.findAll();
    }

    @GetMapping("{id}")
    public Plano listarPlano(@PathVariable Long id){
        Optional opt = this.planoRepository.findById(id);
        if(opt.isPresent()){
            return (Plano)opt.get();
        } else {
            return null;
        }
    }

    @PostMapping
    public Plano criarPlano(@RequestBody Plano plano){
        this.planoRepository.save(plano);
        return plano;
    }

    @PutMapping("{id}")
    public Plano atualizar(@PathVariable Long id, @RequestBody Plano plano){
        Optional opt = this.planoRepository.findById(id);
        if(opt.isPresent()){
            Plano planoOriginal = (Plano) opt.get();
            planoOriginal.setNome(plano.getNome());
            planoOriginal.setValorPorMinuto(plano.getValorPorMinuto());
            this.planoRepository.save(planoOriginal);
            return (Plano)opt.get();
        } else {
            return null;
        }
    }

    @DeleteMapping("{id}")
    public void deletarPlano(@PathVariable Long id){
        this.planoRepository.deleteById(id);
    }
}