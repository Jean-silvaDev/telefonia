package bcc.ifsuldeminas.sistemaDeTelefonia.controller.comercial;

import bcc.ifsuldeminas.sistemaDeTelefonia.model.entities.repositories.comercial.PlanoRepository;
import bcc.ifsuldeminas.sistemaDeTelefonia.model.entities.telefonia.comercial.Plano;
import bcc.ifsuldeminas.sistemaDeTelefonia.model.services.PlanoNotFoundException;
import bcc.ifsuldeminas.sistemaDeTelefonia.model.services.PlanoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//Nome: Jean Francisco Da Silva

@RestController
@RequestMapping("/plano")
public class PlanoController {
    PlanoService planoService;

    public PlanoController(PlanoService planoService){
        this.planoService = planoService;
    }

    @GetMapping
    public ResponseEntity listarPlanos(){
        return new ResponseEntity(this.planoService.read(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity listarPlano(@PathVariable Long id){
        try{
            Plano plano = this.planoService.read(id);
            return new ResponseEntity(plano, HttpStatus.OK);
        } catch (PlanoNotFoundException pnfe){
            return new ResponseEntity(pnfe.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity criarPlano(@RequestBody Plano plano){
        this.planoService.create(plano);
        return new ResponseEntity(plano, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody Plano plano){
        try{
            Plano planoAntigo = this.planoService.update(id, plano);
            return new ResponseEntity(planoAntigo, HttpStatus.OK);
        } catch (PlanoNotFoundException pnfe){
            return new ResponseEntity(pnfe.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity deletarPlano(@PathVariable Long id){
        try{
            this.planoService.delete(id);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }catch (PlanoNotFoundException pnfe){
            return new ResponseEntity(pnfe.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}