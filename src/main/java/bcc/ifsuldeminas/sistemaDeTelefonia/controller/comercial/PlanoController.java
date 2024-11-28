package bcc.ifsuldeminas.sistemaDeTelefonia.controller.comercial;

import bcc.ifsuldeminas.sistemaDeTelefonia.model.entities.telefonia.Operadora;
import bcc.ifsuldeminas.sistemaDeTelefonia.model.entities.telefonia.comercial.Plano;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

//Nome: Jean Francisco Da Silva

@RestController
@RequestMapping("/plano")
public class PlanoController {
    @Autowired
    private Operadora operadora;

    @GetMapping
    public Set<Plano> listarPlanos(){
        return this.operadora.getPlanos();
    }

    @PostMapping
    public void criarPlano(@RequestBody Plano plano){
        this.operadora.addPlano(plano);
        System.out.println(this.operadora.getPlanos());
    }

    @PutMapping("{nome}")
    public void atualizarPlano(@PathVariable String nome, @RequestBody Plano plano){
        Plano planoTest = operadora.getPlanos().stream().filter(x -> x.getNome().equals(nome)).findFirst().get();
        planoTest.setNome(plano.getNome());
        planoTest.setValorPorMinuto(plano.getValorPorMinuto());
    }

    @DeleteMapping("{nome}")
    public void deletarPlano(@PathVariable String nome){
        Plano plano = this.operadora.getPlanos().stream().filter(x -> x.getNome().equals(nome)).findFirst().get();
        this.operadora.removerPlano(plano);
    }

}
